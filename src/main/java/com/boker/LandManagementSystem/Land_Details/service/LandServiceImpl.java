package com.boker.LandManagementSystem.Land_Details.service;

import com.boker.LandManagementSystem.Land_Details.dto.LandRequestDto;
import com.boker.LandManagementSystem.Land_Details.entity.LandEntity;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import com.boker.LandManagementSystem.Land_Details.repository.LandEntityRepository;
import com.boker.LandManagementSystem.Land_Details.repository.LandModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class LandServiceImpl implements LandService {
    private final LandEntityRepository landEntityRepository;
    private final LandModelRepository landModelRepository;

    @Override
    public LandModel createNewLand(LandRequestDto landRequestDto) {
        LandEntity landEntity = new LandEntity();
        landEntity.setLandDescription(landEntity.getLandDescription());
        landEntity.setLandSize(landRequestDto.getLandSize());
        landEntity.setLandRegistrationNumber(landRequestDto.getLandRegistrationNumber());
        landEntity.setLandPlotNumber(landRequestDto.getLandPlotNumber());
        landEntity.setLandSaleStatus(landRequestDto.getLandSaleStatus());
        landEntity.setLandPrice(landRequestDto.getLandPrice());
        landEntity.setOwnerId(landRequestDto.getOwnerId());
        landEntity.setRegFormImage(landRequestDto.getRegFormImage());
        LandEntity saveData = landEntityRepository.save(landEntity);
        return landModelRepository.findByLandRegistrationNumber(saveData.getLandRegistrationNumber());
    }

    @Override
    public Page<LandModel> findAll(Pageable pageable) {
        return landModelRepository.findAll(pageable);
    }

    @Override
    public LandEntity updateLand(LandRequestDto landRequestDto) {
        LandEntity landEntity = landEntityRepository.findByPublicId(landRequestDto.getPublicId()).get();
        landEntity.setLandDescription(landEntity.getLandDescription());
        landEntity.setLandSize(landRequestDto.getLandSize());
        landEntity.setLandRegistrationNumber(landRequestDto.getLandRegistrationNumber());
        landEntity.setLandPlotNumber(landRequestDto.getLandPlotNumber());
        landEntity.setLandSaleStatus(landRequestDto.getLandSaleStatus());
        landEntity.setLandPrice(landRequestDto.getLandPrice());
        landEntity.setOwnerId(landRequestDto.getOwnerId());
        landEntity.setRegFormImage(landRequestDto.getRegFormImage());
        LandEntity saveData = landEntityRepository.save(landEntity);
        return saveData;
    }

    @Override
    public String deleteLand(UUID publicId) {
        LandModel landModel = landModelRepository.findByPublicId(publicId).get();
        landModelRepository.delete(landModel);
        return "deleted";
    }
}
