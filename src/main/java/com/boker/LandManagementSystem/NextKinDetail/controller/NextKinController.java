package com.boker.LandManagementSystem.NextKinDetail.controller;

import com.boker.LandManagementSystem.NextKinDetail.dto.NextKinRequestDto;
import com.boker.LandManagementSystem.NextKinDetail.model.NextKinModel;
import com.boker.LandManagementSystem.NextKinDetail.service.NextKinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
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
