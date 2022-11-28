package com.boker.LandManagementSystem.Land_Owner.repository;

import com.boker.LandManagementSystem.Land_Owner.model.OwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerModelRepository extends JpaRepository<OwnerModel,Long> {
    OwnerModel findByOwnerId(Long ownerId);

}
