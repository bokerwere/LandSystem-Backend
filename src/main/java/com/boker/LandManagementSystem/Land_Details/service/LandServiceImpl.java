package com.boker.LandManagementSystem.Land_Details.service;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Land_Details.dto.LandRequestDto;
import com.boker.LandManagementSystem.Land_Details.entity.LandEntity;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import com.boker.LandManagementSystem.Land_Details.repository.LandEntityRepository;
import com.boker.LandManagementSystem.Land_Details.repository.LandModelRepository;
import com.boker.LandManagementSystem.Land_Details.service.LandService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
        landEntity.setLandPlotNumber(landEntity.getLandPlotNumber());
        landEntity.setLandSaleStatus(landRequestDto.getLandSaleStatus());
        landEntity.setLandPrice(landRequestDto.getLandPrice());
        landEntity.setOwnerId(landRequestDto.getOwnerId());
        landEntity.setBuyerId(landRequestDto.getBuyerId());
        landEntity.setRegFormImage(landEntity.getRegFormImage());
        landEntity.setAddress(new Address(landRequestDto.getAddress().getCounty(), landRequestDto.getAddress().getLocation(), landRequestDto.getAddress().getTown(), landRequestDto.getAddress().getPhysicalAddress()));
        LandEntity saveData = landEntityRepository.save(landEntity);
        return landModelRepository.findByLandId(saveData.getLandId());
    }
}
