package com.boker.LandManagementSystem.Auths.Service;

import com.boker.LandManagementSystem.Auths.Entity.User;

import java.util.List;

public interface UserService {
    User createNewUser(User user);
    public  void addNewRoleToUser(String username , String roleName);
    User getUser(String username);
    List<User>getAllUsers();
}
