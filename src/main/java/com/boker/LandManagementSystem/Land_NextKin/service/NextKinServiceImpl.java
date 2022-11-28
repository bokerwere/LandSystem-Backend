package com.boker.LandManagementSystem.Land_NextKin.service;

import com.boker.LandManagementSystem.Land_NextKin.dto.NextKinRequestDto;
import com.boker.LandManagementSystem.Land_NextKin.entity.NextKinEntity;
import com.boker.LandManagementSystem.Land_NextKin.model.NextKinModel;
import com.boker.LandManagementSystem.Land_NextKin.repository.NextKinEntityRepository;
import com.boker.LandManagementSystem.Land_NextKin.repository.NextKinModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NextKinServiceImpl implements NextKinService{
    private final NextKinModelRepository nextKinModelRepository;
    private final NextKinEntityRepository nextKinEntityRepository;
    @Override
    public NextKinModel createNextKin(NextKinRequestDto nextKinRequestDto) {
        NextKinEntity nextKinEntity=new NextKinEntity();
        nextKinEntity.setFirstName(nextKinRequestDto.getFirstName());
        nextKinEntity.setMiddleName(nextKinRequestDto.getMiddleName());
        nextKinEntity.setSurname(nextKinRequestDto.getSurname());
        nextKinEntity.setGender(nextKinRequestDto.getGender());
        nextKinEntity.setBirthNo(nextKinRequestDto.getBirthNo());
        nextKinEntity.setIdNumber(nextKinRequestDto.getIdNumber());
        nextKinEntity.setOwnerId(nextKinRequestDto.getOwnerId());
        nextKinEntity.setBuyerId(nextKinRequestDto.getBuyerId());
        nextKinEntity.setAge(nextKinRequestDto.getAge());
        nextKinEntity.setPhoneNumber(nextKinRequestDto.getPhoneNumber());
        nextKinEntity.setEmail(nextKinRequestDto.getEmail());
        nextKinEntity.setRelationshipType(nextKinRequestDto.getRelationshipType());
        NextKinEntity savaData=nextKinEntityRepository.save(nextKinEntity);
        return nextKinModelRepository.findByKinId(savaData.getKinId());
    }

    @Override
    public List<NextKinModel> getAllNextKins() {
        return nextKinModelRepository.findAll();
    }
}
