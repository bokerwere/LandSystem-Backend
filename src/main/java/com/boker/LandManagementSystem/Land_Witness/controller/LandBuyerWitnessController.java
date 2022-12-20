package com.boker.LandManagementSystem.Land_Witness.controller;

import com.boker.LandManagementSystem.Land_Witness.Dto.LandBuyerWitnessDto;
import com.boker.LandManagementSystem.Land_Witness.model.LandWitnessModel;
import com.boker.LandManagementSystem.Land_Witness.service.LandWitnessService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("land/v1/")
@RequiredArgsConstructor
public class LandBuyerWitnessController {
    private final LandWitnessService landWitnessService;

    @PostMapping("/createLandWitness")
    public ResponseEntity<LandWitnessModel> createLandWitness(@RequestBody LandBuyerWitnessDto landBuyerWitnessDto) {
        return ResponseEntity.ok(landWitnessService.createLandBuyerWitness(landBuyerWitnessDto));
    }

}
