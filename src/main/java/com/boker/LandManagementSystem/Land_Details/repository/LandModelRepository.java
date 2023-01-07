package com.boker.LandManagementSystem.Land_Details.repository;

import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface LandModelRepository extends JpaRepository<LandModel, Long> {

    LandModel findByLandRegistrationNumber(Long landRegNo);

    Page<LandModel> findAll(Pageable pageable);

    Optional<LandModel> findByPublicId(UUID publicId);


}
