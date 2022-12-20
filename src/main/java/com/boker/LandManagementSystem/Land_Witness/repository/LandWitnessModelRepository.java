package com.boker.LandManagementSystem.Land_Witness.repository;

import com.boker.LandManagementSystem.Land_Witness.model.LandWitnessModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandWitnessModelRepository extends JpaRepository<LandWitnessModel, String> {
    LandWitnessModel findByLandWitnessId(String witnessId);
}
