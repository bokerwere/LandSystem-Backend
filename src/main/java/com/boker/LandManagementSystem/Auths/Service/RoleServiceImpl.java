package com.boker.LandManagementSystem.Auths.Service;

import com.boker.LandManagementSystem.Auths.Entity.Role;
import com.boker.LandManagementSystem.Auths.Repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
   private final RolesRepository rolesRepository;
    @Override
    public Role CreateNewRole(Role role) {
        return rolesRepository.save(role);
    }
}
