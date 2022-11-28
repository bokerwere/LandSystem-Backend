package com.boker.LandManagementSystem.Land_Buyer.repository;

import com.boker.LandManagementSystem.Land_Buyer.model.LandBuyerModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LandBuyerModelRepository extends JpaRepository<LandBuyerModel,Long> {


    LandBuyerModel findByBuyerId(Long buyerId);
}
