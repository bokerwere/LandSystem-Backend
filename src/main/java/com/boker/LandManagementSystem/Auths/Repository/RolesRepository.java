package com.boker.LandManagementSystem.Auths.Repository;

import com.boker.LandManagementSystem.Auths.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role,String> {
    Role findByRoleName(String roleName);
}
