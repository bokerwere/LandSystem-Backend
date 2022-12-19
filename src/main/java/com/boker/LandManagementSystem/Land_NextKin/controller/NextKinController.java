package com.boker.LandManagementSystem.Land_NextKin.controller;

import com.boker.LandManagementSystem.Land_NextKin.dto.NextKinRequestDto;
import com.boker.LandManagementSystem.Land_NextKin.model.NextKinModel;
import com.boker.LandManagementSystem.Land_NextKin.service.NextKinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("land/")
@RequiredArgsConstructor
public class NextKinController {
    private  final NextKinService nextKinService;
    @PostMapping("/createNextKin")
    public ResponseEntity<NextKinModel>createNewNextKin(@RequestBody NextKinRequestDto kinRequestDto){
        return ResponseEntity.ok(nextKinService.createNextKin(kinRequestDto));
    }
    @GetMapping(value = "/getAllNextKins")
    public ResponseEntity<List<NextKinModel>>getAllNextKins(){
      return   ResponseEntity.ok(nextKinService.getAllNextKins());
    }
}
