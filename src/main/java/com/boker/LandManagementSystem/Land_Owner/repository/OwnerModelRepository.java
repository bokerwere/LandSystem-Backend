package com.boker.LandManagementSystem.Land_Owner.repository;

import com.boker.LandManagementSystem.Land_Owner.model.OwnerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface OwnerModelRepository extends JpaRepository<OwnerModel,Long> {
    OwnerModel findByOwnerId(String ownerId);

    Page<OwnerModel> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);

}
