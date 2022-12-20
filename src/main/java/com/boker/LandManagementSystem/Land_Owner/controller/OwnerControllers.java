package com.boker.LandManagementSystem.Land_Owner.controller;

import com.boker.LandManagementSystem.Land_Owner.dto.OwnerRequest;
import com.boker.LandManagementSystem.Land_Owner.dto.response.LandOwnerResponseDto;
import com.boker.LandManagementSystem.Land_Owner.entity.OwnerEntity;
import com.boker.LandManagementSystem.Land_Owner.model.OwnerModel;
import com.boker.LandManagementSystem.Land_Owner.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/land/v1")
public class OwnerControllers {
    @Autowired
    private OwnerService ownerService;
    @PostMapping("/createOwner")
    public ResponseEntity<OwnerModel> createLandOwners(@RequestBody OwnerRequest ownerRequest){
        return ResponseEntity.ok(ownerService.createOwner(ownerRequest));
    }
    @PutMapping("/updateOwner")
    public ResponseEntity<OwnerEntity> updatesLandOwners(@RequestBody OwnerRequest ownerRequest){
        return ResponseEntity.ok(ownerService.updateOwner(ownerRequest));
    }
    @GetMapping(value = "/getAllOwners")
    public ResponseEntity<List<OwnerModel>>getAll(){
        return ResponseEntity.ok(ownerService.getAllOwners());
    }
    @DeleteMapping("/deleteLandOwner")
   public  ResponseEntity<String>deleteLandOwner(@RequestParam(name="publicId") UUID publicId){
        return  ResponseEntity.ok(ownerService.deleteLandOwner(publicId));

   }
//    @GetMapping("/filter-landOwner")
//    public ResponseEntity<Page<LandOwnerResponseDto>> getC2BTransaction(@RequestParam(value = "startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
//                                                                        @RequestParam(value = "endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate, Pageable pageable) {
//        Page<LandOwnerResponseDto> results;
//        if (!ObjectUtils.isEmpty(startDate) && !ObjectUtils.isEmpty(endDate)) {
//            results =ownerService.findByDateRange(startDate, endDate, pageable);
//            return ResponseEntity.status(HttpStatus.OK).body(results);
//        }
//     return  ResponseEntity.ok(ownerService.findByDateRange(startDate, endDate, pageable));
//    }

}