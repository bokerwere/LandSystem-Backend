package com.boker.LandManagementSystem.Land_Witness.service;

import com.boker.LandManagementSystem.Land_Witness.Dto.LandBuyerWitnessDto;
import com.boker.LandManagementSystem.Land_Witness.model.LandWitnessModel;

public interface LandWitnessService {
    LandWitnessModel createLandBuyerWitness(LandBuyerWitnessDto landBuyerWitnessDto);


}
