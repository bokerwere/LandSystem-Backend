package com.boker.LandManagementSystem.Land_Witness.repository;


import com.boker.LandManagementSystem.Land_Witness.Entity.LandWitnessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandWitnessEntityRepository  extends JpaRepository<LandWitnessEntity, String> {
}
