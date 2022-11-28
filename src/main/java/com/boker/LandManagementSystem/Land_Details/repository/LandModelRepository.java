package com.boker.LandManagementSystem.Land_Details.repository;

import com.boker.LandManagementSystem.Land_Buyer.model.LandBuyerModel;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LandModelRepository  extends JpaRepository<LandModel,Long> {

    LandModel findByLandId(Long landId);
}
