package com.boker.LandManagementSystem.Land_Details.repository;

import com.boker.LandManagementSystem.Land_Details.entity.LandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LandEntityRepository extends JpaRepository<LandEntity, String> {

    Optional<LandEntity>findByPublicId(UUID publicId);

}
