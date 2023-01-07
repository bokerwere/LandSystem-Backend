package com.boker.LandManagementSystem.Land_Details.controller;

import com.boker.LandManagementSystem.Land_Details.dto.LandRequestDto;
import com.boker.LandManagementSystem.Land_Details.entity.LandEntity;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import com.boker.LandManagementSystem.Land_Details.service.LandService;
import com.boker.LandManagementSystem.imageUpload.ImageModel;
import com.boker.LandManagementSystem.imageUpload.ImageUploadServiceProcess;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("land/v1/")
@RequiredArgsConstructor
@Slf4j
public class LandController {

    private final LandService landService;
    private final ImageUploadServiceProcess imageUploadServiceProcess;
    private  final ObjectMapper  mapper;

    @SneakyThrows
    @PostMapping(value = "/createNewLand", produces = {"application/json"},
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<LandModel> createNewLand(@RequestPart(value = "lands") LandRequestDto landRequestDto, @RequestPart(value = "file", required = true) MultipartFile[] file) {

//        Set<ImageModel> images = imageUploadServiceProcess.uploadImage(file);
//
//
//        LandEntity landEntity = new LandEntity();
//        landEntity.setLandImages(images);
        return ResponseEntity.ok(landService.createNewLand(landRequestDto,file));
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