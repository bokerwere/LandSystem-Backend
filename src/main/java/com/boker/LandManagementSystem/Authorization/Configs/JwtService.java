package com.boker.LandManagementSystem.Authorization.Configs;

import com.boker.LandManagementSystem.Authorization.Util.JwtUtil;
import com.boker.LandManagementSystem.Auths.Entity.JwtRequest;
import com.boker.LandManagementSystem.Auths.Entity.JwtResponse;
import com.boker.LandManagementSystem.Auths.Entity.User;
import com.boker.LandManagementSystem.Auths.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class JwtService implements UserDetailsService {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName, userPassword);

        UserDetails userDetails = loadUserByUsername(userName);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);

        User user = userDao.findByPhoneNumber(userName).get();
        return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByPhoneNumber(username).get();
        log.info("user{}", user);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(
                    user.getPhoneNumber(),
                    user.getPassword(),
                    getAuthority(user)
            );
        } else {
            log.info("{User not found with username:}", username);
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    private Set getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getUserRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        });
        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

    //Resetting Password
    public User resetPassword(String phoneNumber, String newPassword) {
        try {
            User userTabData = userDao.findByPhoneNumber(phoneNumber).get();
            userTabData.setPassword(passwordEncoder.encode(newPassword));
            return userDao.save(userTabData);
        } catch (Exception e) {
            log.info("e---" + e);
            throw new ResponseStatusException(
                    HttpStatus.NOT_ACCEPTABLE,
                    e.getMessage()
            );
        }
    }


}
