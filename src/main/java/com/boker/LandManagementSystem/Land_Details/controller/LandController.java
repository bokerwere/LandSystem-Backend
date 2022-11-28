package com.boker.LandManagementSystem.Land_Details.controller;

import com.boker.LandManagementSystem.Land_Details.dto.LandRequestDto;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import com.boker.LandManagementSystem.Land_Details.service.LandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("land/")
@RequiredArgsConstructor
public class LandController {

    private final LandService landService;

    @PostMapping(value = "/createNewLand")

    public ResponseEntity<LandModel> createNewLand(@RequestBody LandRequestDto landRequestDto) {
        return ResponseEntity.ok(landService.createNewLand(landRequestDto));
    }

}
