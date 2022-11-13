package com.boker.LandManagementSystem.Owner.repository;

import com.boker.LandManagementSystem.Owner.model.OwnerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OwnerModelRepository extends JpaRepository<OwnerModel,Long> {
    OwnerModel findByOwnerId(Long ownerId);

}
