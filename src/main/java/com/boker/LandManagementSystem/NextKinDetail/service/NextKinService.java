package com.boker.LandManagementSystem.NextKinDetail.service;

import com.boker.LandManagementSystem.NextKinDetail.dto.NextKinRequestDto;
import com.boker.LandManagementSystem.NextKinDetail.model.NextKinModel;

import java.util.List;

public interface NextKinService {
    NextKinModel createNextKin(NextKinRequestDto nextKinRequestDto);

    List<NextKinModel> getAllNextKins();
}
