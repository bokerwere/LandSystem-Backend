package com.boker.LandManagementSystem.Auths.Repository;

import com.boker.LandManagementSystem.Auths.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
User findByUserName(String username);

}
