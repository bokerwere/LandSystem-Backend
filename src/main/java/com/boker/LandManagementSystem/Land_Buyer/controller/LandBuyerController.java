package com.boker.LandManagementSystem.Land_Buyer.controller;

import com.boker.LandManagementSystem.Commons.ApiResponse;
import com.boker.LandManagementSystem.Land_Buyer.dto.LandBuyerDto;
import com.boker.LandManagementSystem.Land_Buyer.model.LandBuyerModel;
import com.boker.LandManagementSystem.Land_Buyer.service.LandBuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("land/")
@RequiredArgsConstructor
public class LandBuyerController {
    private final LandBuyerService landBuyerService;

    @PostMapping("createLandBuyer/")
    public ResponseEntity<LandBuyerModel> createLandBuyer(@RequestBody LandBuyerDto landBuyerDto) {
        return ResponseEntity.ok(landBuyerService.createLandBuyer(landBuyerDto));
    }

    @GetMapping("getAllLandBuyers")
    public ResponseEntity<ApiResponse<List<LandBuyerModel>>> getAllLandBuyers() {
        List<LandBuyerModel> landBuyerModelList = landBuyerService.getAllLandBuyers();
        return ResponseEntity.ok(new ApiResponse<>(landBuyerModelList.size(), landBuyerModelList));
    }

    @GetMapping("getAllLandBuyersByPage/{offset}/{pageSize}")
    public ApiResponse<Page<LandBuyerModel> >findLandBuyersByPagination(@PathVariable int offset, @PathVariable int pageSize) {
        Page<LandBuyerModel>landBuyerModels=landBuyerService.findLandBuyerPagination(offset,pageSize);

        return new ApiResponse<>(landBuyerModels.getTotalPages(),landBuyerModels);

    }

}