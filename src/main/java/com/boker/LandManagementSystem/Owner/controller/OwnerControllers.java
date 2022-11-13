package com.boker.LandManagementSystem.Owner.controller;

import com.boker.LandManagementSystem.Owner.dto.OwnerRequest;
import com.boker.LandManagementSystem.Owner.model.OwnerModel;
import com.boker.LandManagementSystem.Owner.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/land")
public class OwnerControllers {
    @Autowired
    private OwnerService ownerService;
    @PostMapping("/createOwner")
    public ResponseEntity<OwnerModel> createLandOwners(@RequestBody OwnerRequest ownerRequest){
        return ResponseEntity.ok(ownerService.createOwner(ownerRequest));
    }
//    @PutMapping("/updateOwner")
//    public ResponseEntity<OwnerEntity> updatesLandOwners(@RequestBody OwnerRequest ownerRequest){
//        return ResponseEntity.ok(ownerService.update(ownerRequest));
//    }
    @GetMapping(value = "getAllOwners")
    public ResponseEntity<List<OwnerModel>>getAll(){
        return ResponseEntity.ok(ownerService.getAllOwners());
    }


}
