package com.boker.LandManagementSystem.Land_Details.service;

import com.boker.LandManagementSystem.Land_Details.dto.LandRequestDto;
import com.boker.LandManagementSystem.Land_Details.entity.LandEntity;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import com.boker.LandManagementSystem.Land_Details.repository.LandEntityRepository;
import com.boker.LandManagementSystem.Land_Details.repository.LandModelRepository;
import com.boker.LandManagementSystem.imageUpload.ImageModel;
import com.boker.LandManagementSystem.imageUpload.ImageRepository;
import com.boker.LandManagementSystem.imageUpload.ImageUploadServiceProcess;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class LandServiceImpl implements LandService {
    private final ImageUploadServiceProcess imageUploadServiceProcess;
    private final LandEntityRepository landEntityRepository;
    private final LandModelRepository landModelRepository;
    private final ObjectMapper mapper = new ObjectMapper();
    private  final ImageRepository imageRepository;

    @SneakyThrows
    @Override
    public LandModel createNewLand(LandRequestDto landRequestDto , MultipartFile[] file) {
        LandEntity landEntity = new LandEntity();
        Set<ImageModel> images = imageUploadServiceProcess.uploadImage(file);
        imageRepository.saveAll(images);
        landEntity.setLandImages(images);
        log.info("image=={}",mapper.writeValueAsString(landEntity.getLandImages()));
        landEntity.setLandDescription(landEntity.getLandDescription());
        landEntity.setLandSize(landRequestDto.getLandSize());
       //landEntity.setLandRegistrationNumber(landRequestDto.getLandRegistrationNumber());
        landEntity.setLandPlotNumber(landRequestDto.getLandPlotNumber());
        landEntity.setLandSaleStatus(landRequestDto.getLandSaleStatus());
        landEntity.setLandPrice(landRequestDto.getLandPrice());
        landEntity.setOwnerId(landRequestDto.getOwnerId());
        landEntity.setRegFormImage(landRequestDto.getRegFormImage());
        LandEntity saveData = landEntityRepository.save(landEntity);
        return landModelRepository.findByLandRegistrationNumber(saveData.getLandRegistrationNumber());
    }

    @Override
    public Page<LandModel> findAll(Pageable pageable) {
        return landModelRepository.findAll(pageable);
    }

    @SneakyThrows
    @Override
    public LandEntity updateLand(LandRequestDto landRequestDto) {
        LandEntity landEntity = landEntityRepository.findByPublicId(landRequestDto.getPublicId()).get();
        landEntity.setLandDescription(landEntity.getLandDescription());
        landEntity.setLandSize(landRequestDto.getLandSize());
      //  landEntity.setLandRegistrationNumber(landRequestDto.getLandRegistrationNumber());
        landEntity.setLandPlotNumber(landRequestDto.getLandPlotNumber());
        landEntity.setLandSaleStatus(landRequestDto.getLandSaleStatus());
        landEntity.setLandPrice(landRequestDto.getLandPrice());
        landEntity.setOwnerId(landRequestDto.getOwnerId());
        landEntity.setRegFormImage(landRequestDto.getRegFormImage());
        LandEntity saveData = landEntityRepository.save(landEntity);
        log.info("land-body{}", mapper.writeValueAsString(saveData));
        return saveData;
    }

    @Override
    public String deleteLand(UUID publicId) {
        LandModel landModel = landModelRepository.findByPublicId(publicId).get();
        landModelRepository.delete(landModel);
        return "deleted";
    }
}
