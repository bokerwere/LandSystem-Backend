package com.boker.LandManagementSystem.Land_Details.controller;

import com.boker.LandManagementSystem.Land_Details.dto.LandRequestDto;
import com.boker.LandManagementSystem.Land_Details.entity.LandEntity;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import com.boker.LandManagementSystem.Land_Details.service.LandService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("land/v1/")
@RequiredArgsConstructor
public class LandController {

    private final LandService landService;

    @PostMapping(value = "/createNewLand")
    public ResponseEntity<LandModel> createNewLand(@RequestBody LandRequestDto landRequestDto) {
        return ResponseEntity.ok(landService.createNewLand(landRequestDto));
    }

    @GetMapping("/getAllLands")
    public ResponseEntity<Page<LandModel>> findAll(Pageable pageable) {
        return ResponseEntity.ok(landService.findAll(pageable));
    }

    @PutMapping("/updateLand")
    public ResponseEntity<LandEntity> updatesLand(@RequestBody LandRequestDto landRequestDto) {
        return ResponseEntity.ok(landService.updateLand(landRequestDto));
    }

    @DeleteMapping("/deleteLand")
    public ResponseEntity<String> deleteLandOwner(@RequestParam(name = "publicId") UUID publicId) {
        return ResponseEntity.ok(landService.deleteLand(publicId));


    }
}