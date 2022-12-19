package com.boker.LandManagementSystem.Auths.Repository;

import com.boker.LandManagementSystem.Auths.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
User findByUserName(String username);


    Optional<User> findByPhoneNumber(String username);
}
