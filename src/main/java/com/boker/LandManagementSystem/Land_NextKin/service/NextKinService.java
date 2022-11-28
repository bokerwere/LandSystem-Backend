package com.boker.LandManagementSystem.Land_NextKin.service;

import com.boker.LandManagementSystem.Land_NextKin.dto.NextKinRequestDto;
import com.boker.LandManagementSystem.Land_NextKin.model.NextKinModel;

import java.util.List;

public interface NextKinService {
    NextKinModel createNextKin(NextKinRequestDto nextKinRequestDto);

    List<NextKinModel> getAllNextKins();
}
