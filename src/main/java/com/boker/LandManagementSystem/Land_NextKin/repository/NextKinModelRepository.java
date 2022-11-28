package com.boker.LandManagementSystem.Land_NextKin.repository;

import com.boker.LandManagementSystem.Land_NextKin.model.NextKinModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NextKinModelRepository extends JpaRepository<NextKinModel,Long> {
    NextKinModel findByKinId(Long kinId);

}
