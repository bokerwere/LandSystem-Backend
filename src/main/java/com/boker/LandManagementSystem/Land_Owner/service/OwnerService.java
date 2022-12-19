package com.boker.LandManagementSystem.Land_Owner.service;

import com.boker.LandManagementSystem.Land_Owner.dto.OwnerRequest;
import com.boker.LandManagementSystem.Land_Owner.dto.response.LandOwnerResponseDto;
import com.boker.LandManagementSystem.Land_Owner.entity.OwnerEntity;
import com.boker.LandManagementSystem.Land_Owner.model.OwnerModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface OwnerService {
    OwnerModel createOwner(OwnerRequest ownerRequest);

    List<OwnerModel> getAllOwners();

    OwnerEntity updateOwner(OwnerRequest ownerRequest);

    String deleteLandOwner(UUID publicId);

    //Page<LandOwnerResponseDto>findByDateRange(LocalDate startDate, LocalDate endDate, Pageable pageable);




}
