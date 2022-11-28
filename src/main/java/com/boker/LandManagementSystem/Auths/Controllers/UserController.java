package com.boker.LandManagementSystem.Auths.Controllers;

import com.boker.LandManagementSystem.Auths.Dtos.RoleToUserDto;
import com.boker.LandManagementSystem.Auths.Entity.User;
import com.boker.LandManagementSystem.Auths.Service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("auth/")
public class UserController {
    private final UserService userService;

    @PostMapping(value = "/createNewUser")
    public ResponseEntity<User> createNewUser(@RequestBody User user) {

        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(user));
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/addRoleToUser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserDto roleToUserDto) {
        log.info("add role {} to user {}",roleToUserDto.getRoleName(),roleToUserDto.getUserName());
        userService.addNewRoleToUser(roleToUserDto.getUserName(), roleToUserDto.getRoleName());
        return ResponseEntity.ok().build();
    }


}

