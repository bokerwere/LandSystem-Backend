package com.boker.LandManagementSystem.Auths.Entity;

import lombok.Data;

@Data
public class JwtRequest {
    private String userName;
    private String userPassword;
}
