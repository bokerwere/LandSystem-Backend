package com.boker.LandManagementSystem.Auths.Controllers;

import com.boker.LandManagementSystem.Authorization.Configs.JwtService;
import com.boker.LandManagementSystem.Auths.Entity.JwtRequest;
import com.boker.LandManagementSystem.Auths.Entity.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        return jwtService.createJwtToken(jwtRequest);
    }

    @PutMapping(value = "/resetPassowrd")
    public ResponseEntity<?> resetPassowrd(
            @RequestParam("PHONE") String phoneNumber,
            @RequestParam("NEW_PASSWORD") String newPassword
    ) {
        return ResponseEntity.ok(jwtService.resetPassword( phoneNumber, newPassword));
    }
}


