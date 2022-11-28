package com.boker.LandManagementSystem.Land_Details.service;

import com.boker.LandManagementSystem.Land_Details.dto.LandRequestDto;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;

public interface LandService {
    LandModel createNewLand(LandRequestDto landRequestDto);
}
