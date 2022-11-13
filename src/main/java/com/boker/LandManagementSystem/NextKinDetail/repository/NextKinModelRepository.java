package com.boker.LandManagementSystem.NextKinDetail.repository;

import com.boker.LandManagementSystem.NextKinDetail.entity.NextKinEntity;
import com.boker.LandManagementSystem.NextKinDetail.model.NextKinModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NextKinModelRepository extends JpaRepository<NextKinModel,Long> {
    NextKinModel findByKinId(Long kinId);

}
