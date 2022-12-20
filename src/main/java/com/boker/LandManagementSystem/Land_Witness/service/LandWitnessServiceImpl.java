package com.boker.LandManagementSystem.Land_Witness.service;

import com.boker.LandManagementSystem.Land_Witness.Dto.LandBuyerWitnessDto;
import com.boker.LandManagementSystem.Land_Witness.Entity.LandWitnessEntity;
import com.boker.LandManagementSystem.Land_Witness.model.LandWitnessModel;
import com.boker.LandManagementSystem.Land_Witness.repository.LandWitnessEntityRepository;
import com.boker.LandManagementSystem.Land_Witness.repository.LandWitnessModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LandWitnessServiceImpl implements LandWitnessService {
    private final LandWitnessEntityRepository landWitnessEntityRepository;
    private final LandWitnessModelRepository landWitnessModelRepository;

    @Override
    public LandWitnessModel createLandBuyerWitness(LandBuyerWitnessDto landBuyerWitnessDto) {
        LandWitnessEntity landWitnessEntity = new LandWitnessEntity();
        landWitnessEntity.setLandWitnessId(landBuyerWitnessDto.getLandWitnessId());
        landWitnessEntity.setLandOwnerId(landBuyerWitnessDto.getLandOwnerId());
        landWitnessEntity.setLandBuyerId(landBuyerWitnessDto.getLandBuyerId());
        landWitnessEntity.setWitnessFirstName(landBuyerWitnessDto.getWitnessFirstName());
        landWitnessEntity.setWitnessLastName(landBuyerWitnessDto.getWitnessLastName());
        landWitnessEntity.setWitnessPhoneNumber(landBuyerWitnessDto.getWitnessPhoneNumber());
        landWitnessEntity.setWitnessEmail(landBuyerWitnessDto.getWitnessEmail());
        LandWitnessEntity savaData = landWitnessEntityRepository.save(landWitnessEntity);
        return landWitnessModelRepository.findByLandWitnessId(savaData.getLandWitnessId());
    }
}
