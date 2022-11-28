package com.boker.LandManagementSystem.Land_Details.repository;

import com.boker.LandManagementSystem.Land_Details.entity.LandEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LandEntityRepository extends JpaRepository<LandEntity,Long> {

}
