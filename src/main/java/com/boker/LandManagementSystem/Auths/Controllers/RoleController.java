package com.boker.LandManagementSystem.Auths.Controllers;

import com.boker.LandManagementSystem.Auths.Entity.Role;
import com.boker.LandManagementSystem.Auths.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(name = "auth/")
public class RoleController {
    private  final RoleService roleService;
    @PostMapping(value = "/createNewRole")
    public ResponseEntity<Role> createNewRole(@RequestBody Role role){
        return  ResponseEntity.ok(roleService.CreateNewRole(role));
    }
}
