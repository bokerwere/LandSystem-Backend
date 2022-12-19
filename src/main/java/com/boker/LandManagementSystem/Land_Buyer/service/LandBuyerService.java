package com.boker.LandManagementSystem.Land_Buyer.service;

import com.boker.LandManagementSystem.Land_Buyer.dto.LandBuyerDto;
import com.boker.LandManagementSystem.Land_Buyer.model.LandBuyerModel;
import org.springframework.data.domain.Page;

import java.util.List;

public interface LandBuyerService {
    LandBuyerModel createLandBuyer( LandBuyerDto landBuyerDto);
    List<LandBuyerModel> getAllLandBuyers();
    Page<LandBuyerModel>findLandBuyerPagination(int offset,int pageSize);
}
