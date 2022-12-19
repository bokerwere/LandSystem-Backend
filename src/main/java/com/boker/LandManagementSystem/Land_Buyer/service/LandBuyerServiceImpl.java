package com.boker.LandManagementSystem.Land_Buyer.service;

import com.boker.LandManagementSystem.Land_Buyer.dto.LandBuyerDto;
import com.boker.LandManagementSystem.Land_Buyer.entity.LandBuyerEntity;
import com.boker.LandManagementSystem.Land_Buyer.model.LandBuyerModel;
import com.boker.LandManagementSystem.Land_Buyer.repository.LandBuyerEntityRepository;
import com.boker.LandManagementSystem.Land_Buyer.repository.LandBuyerModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
        landBuyerEntity.setLandRegistrationNumber(landBuyerDto.getLandRegistrationNumber());
        landBuyerEntity.setFirstName(landBuyerDto.getFirstName());
        landBuyerEntity.setMiddleName(landBuyerDto.getMiddleName());
        landBuyerEntity.setSurname(landBuyerDto.getSurname());
        landBuyerEntity.setPhoneNumber(landBuyerDto.getPhoneNumber());
        landBuyerEntity.setEmail(landBuyerDto.getEmail());
        landBuyerEntity.setGender(landBuyerDto.getGender());
        landBuyerEntity.setAddress(landBuyerDto.getAddress());
        landBuyerEntity.setNationality(landBuyerDto.getNationality());
        landBuyerEntity.getAddress().setLocation(landBuyerDto.getAddress().getLocation());
        landBuyerEntity.getAddress().setPhysicalAddress(landBuyerDto.getAddress().getPhysicalAddress());
        landBuyerEntity.getAddress().setTown(landBuyerDto.getAddress().getTown());
        landBuyerEntity.getAddress().setCounty(landBuyerDto.getAddress().getCounty());


        LandBuyerEntity savaData = landBuyerEntityRepository.save(landBuyerEntity);
        return landBuyerModelRepository.findByBuyerId(savaData.getBuyerId());

    }

    @Override
    public List<LandBuyerModel> getAllLandBuyers() {
        return landBuyerModelRepository.findAll();
    }

    @Override
    public Page<LandBuyerModel> findLandBuyerPagination(int offset, int pageSize) {
        Page<LandBuyerModel> landBuyerModels = landBuyerModelRepository.findAll(PageRequest.of(offset, pageSize));
        return landBuyerModels;
    }
}
