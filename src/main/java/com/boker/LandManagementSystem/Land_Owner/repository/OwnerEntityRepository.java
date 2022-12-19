package com.boker.LandManagementSystem.Land_Owner.repository;

import com.boker.LandManagementSystem.Land_Owner.entity.OwnerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OwnerEntityRepository extends JpaRepository<OwnerEntity,Long> {

    Optional<OwnerEntity> findByPublicId(UUID public_id);

}
