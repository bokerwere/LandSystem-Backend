package com.boker.LandManagementSystem.Land_Owner.service;

import com.boker.LandManagementSystem.Land_Owner.dto.OwnerRequest;
import com.boker.LandManagementSystem.Land_Owner.entity.OwnerEntity;
import com.boker.LandManagementSystem.Land_Owner.model.OwnerModel;
import com.boker.LandManagementSystem.Land_Owner.repository.OwnerEntityRepository;
import com.boker.LandManagementSystem.Land_Owner.repository.OwnerModelRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OwnerServiceImpl implements OwnerService {
    private final OwnerEntityRepository ownerEntityRepository;
    private final OwnerModelRepository ownerModelRepository;
    private final ObjectMapper objectMapper;

    @Override
    public OwnerModel createOwner(OwnerRequest ownerRequest) {
        OwnerEntity ownerEntity = new OwnerEntity();
        ownerEntity.setOwnerId(ownerRequest.getOwnerId());
        ownerEntity.setFirstName(ownerRequest.getFirstName());
        ownerEntity.setMiddleName(ownerRequest.getMiddleName());
        ownerEntity.setSurname(ownerRequest.getSurname());
        ownerEntity.setEmail(ownerRequest.getEmail());
        ownerEntity.setPhoneNumber(ownerRequest.getPhoneNumber());
        ownerEntity.setAddress(ownerRequest.getAddress());
        ownerEntity.setGender(ownerRequest.getGender());
        ownerEntity.getAddress().setPhysicalAddress(ownerRequest.getAddress().getPhysicalAddress());
        ownerEntity.getAddress().setCounty(ownerRequest.getAddress().getCounty());
        ownerEntity.getAddress().setTown(ownerRequest.getAddress().getTown());
        ownerEntity.getAddress().setLocation(ownerRequest.getAddress().getLocation());
        OwnerEntity saverOwner = ownerEntityRepository.save(ownerEntity);
        return ownerModelRepository.findByOwnerId(saverOwner.getOwnerId());
    }

    @Override
    public List<OwnerModel> getAllOwners() {
        return ownerModelRepository.findAll();
    }

    @SneakyThrows
    @Override
    public OwnerEntity updateOwner(OwnerRequest ownerRequest) {
        OwnerEntity ownerEntity = ownerEntityRepository.findByPublicId(ownerRequest.getPublicId()).orElseThrow(() -> new NoSuchElementException("owner does not exit"));
        log.info("land_owner{}", objectMapper.writeValueAsString(ownerEntity));
        ownerEntity.setFirstName(ownerRequest.getFirstName());
        ownerEntity.setMiddleName(ownerRequest.getMiddleName());
        ownerEntity.setSurname(ownerRequest.getSurname());
        ownerEntity.setEmail(ownerRequest.getEmail());
        ownerEntity.setAddress(ownerRequest.getAddress());
        ownerEntity.getAddress().setPhysicalAddress(ownerRequest.getAddress().getPhysicalAddress());
        ownerEntity.getAddress().setCounty(ownerRequest.getAddress().getCounty());
        ownerEntity.getAddress().setTown(ownerRequest.getAddress().getTown());
        ownerEntity.getAddress().setLocation(ownerRequest.getAddress().getLocation());
        ownerEntity.setPhoneNumber(ownerRequest.getPhoneNumber());
        ownerEntityRepository.save(ownerEntity);
        return ownerEntityRepository.save(ownerEntity);
    }

    @Override
    public String deleteLandOwner(UUID publicId) {
        OwnerEntity ownerEntity = ownerEntityRepository.findByPublicId(publicId).orElseThrow(() -> new NoSuchElementException("owner does not exit"));
        ownerEntityRepository.delete(ownerEntity);
        return "deleted";
    }

//    @Override
//    public Page<LandOwnerResponseDto> findByDateRange(LocalDate startDate, LocalDate endDate, Pageable pageable) {
//        LocalDateTime startLocalDateTime = startDate.atStartOfDay();
//        LocalDateTime endLocalDateTime = endDate.atTime(LocalTime.MAX);
//        Page<OwnerModel> ownerModels = ownerModelRepository.findByCreatedAtBetween(startLocalDateTime, endLocalDateTime, pageable);
//        return new PageImpl<>(landOwnerResponseDtoList, pageable, ownerModels.getTotalElements());
//    }


}
