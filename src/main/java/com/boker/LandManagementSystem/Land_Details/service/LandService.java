package com.boker.LandManagementSystem.Land_Details.service;

import com.boker.LandManagementSystem.Land_Details.dto.LandRequestDto;
import com.boker.LandManagementSystem.Land_Details.entity.LandEntity;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface LandService {
    LandModel createNewLand(LandRequestDto landRequestDto);
    Page<LandModel>findAll(Pageable pageable);
    LandEntity updateLand(LandRequestDto landRequestDto);

    String deleteLand(UUID publicId);
}
