package com.boker.LandManagementSystem.Land_Buyer.repository;

import com.boker.LandManagementSystem.Land_Buyer.entity.LandBuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandBuyerEntityRepository  extends JpaRepository<LandBuyerEntity,String> {
}
