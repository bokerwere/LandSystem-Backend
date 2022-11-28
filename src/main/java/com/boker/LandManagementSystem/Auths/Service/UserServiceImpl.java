package com.boker.LandManagementSystem.Auths.Service;

import com.boker.LandManagementSystem.Auths.Entity.Role;
import com.boker.LandManagementSystem.Auths.Entity.User;
import com.boker.LandManagementSystem.Auths.Repository.RolesRepository;
import com.boker.LandManagementSystem.Auths.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService , UserDetailsService {
    private  final UserRepository userRepository;
    private  final RolesRepository rolesRepository;
    private  final PasswordEncoder passwordEncoder;
    @Override
    public User createNewUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("saving new user {} to the database", user.getUserName());
        return  userRepository.save(user);
    }

    @Override
    public void addNewRoleToUser(String username, String roleName) {
        User user =userRepository.findByUserName(username);
        Role role=rolesRepository.findByRoleName(roleName);
        user.getUserRole().add(role);
    }

    @Override
    public User getUser(String username) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUserName(username);
        if(user==null){
            log.error("User not found in database");
          throw   new UsernameNotFoundException("User not found in database");
        }else {
            log.info("user found in database {}",username);
        }
        Collection<SimpleGrantedAuthority>authorities=new ArrayList<>();
        user.getUserRole().forEach(role ->  authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
        return new  org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
    }
}
