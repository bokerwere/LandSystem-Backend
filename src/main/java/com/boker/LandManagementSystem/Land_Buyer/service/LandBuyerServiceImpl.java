package com.boker.LandManagementSystem.Land_Buyer.service;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Land_Buyer.dto.LandBuyerDto;
import com.boker.LandManagementSystem.Land_Buyer.entity.LandBuyerEntity;
import com.boker.LandManagementSystem.Land_Buyer.model.LandBuyerModel;
import com.boker.LandManagementSystem.Land_Buyer.repository.LandBuyerEntityRepository;
import com.boker.LandManagementSystem.Land_Buyer.repository.LandBuyerModelRepository;
import com.boker.LandManagementSystem.Land_Details.repository.LandModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
/*
 * @author boker
 *
 * */

@Service
@RequiredArgsConstructor
public class LandBuyerServiceImpl implements LandBuyerService {
   private final LandBuyerModelRepository landBuyerModelRepository;
    private final LandBuyerEntityRepository landBuyerEntityRepository;

    @Override
    public LandBuyerModel createLandBuyer(LandBuyerDto landBuyerDto) {
        LandBuyerEntity landBuyerEntity = new LandBuyerEntity();
        landBuyerEntity.setBuyerId(landBuyerDto.getBuyerId());
        landBuyerEntity.setFirstName(landBuyerDto.getFirstName());
        landBuyerEntity.setMiddleName(landBuyerEntity.getMiddleName());
        landBuyerEntity.setSurname(landBuyerDto.getSurname());
        landBuyerEntity.setPhoneNumber(landBuyerDto.getPhoneNumber());
        landBuyerEntity.setEmail(landBuyerDto.getEmail());
        landBuyerEntity.setAddress(new Address(landBuyerDto.getAddress().getCounty(),
                landBuyerDto.getAddress().getLocation(), landBuyerDto.getAddress().getTown(), landBuyerDto.getAddress().getPhysicalAddress()));

        LandBuyerEntity savaData = landBuyerEntityRepository.save(landBuyerEntity);
        return landBuyerModelRepository.findByBuyerId(savaData.getBuyerId());

    }

    @Override
    public List<LandBuyerModel> getAllLandBuyers() {
        return landBuyerModelRepository.findAll();
    }

    @Override
    public Page<LandBuyerModel> findLandBuyerPagination(int offset, int pageSize) {
        Page<LandBuyerModel>landBuyerModels=landBuyerModelRepository.findAll(PageRequest.of(offset, pageSize));
        return landBuyerModels;
    }
}
