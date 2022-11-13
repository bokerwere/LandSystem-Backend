package com.boker.LandManagementSystem.NextKinDetail.service;

import com.boker.LandManagementSystem.NextKinDetail.dto.NextKinRequestDto;
import com.boker.LandManagementSystem.NextKinDetail.entity.NextKinEntity;
import com.boker.LandManagementSystem.NextKinDetail.model.NextKinModel;
import com.boker.LandManagementSystem.NextKinDetail.repository.NextKinEntityRepository;
import com.boker.LandManagementSystem.NextKinDetail.repository.NextKinModelRepository;
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
        nextKinEntity.setBirthNo(nextKinRequestDto.getBirthNo());
        nextKinEntity.setIdNumber(nextKinRequestDto.getIdNumber());
        nextKinEntity.setOwnerId(nextKinRequestDto.getOwnerId());
        nextKinEntity.setAge(nextKinRequestDto.getAge());
        NextKinEntity savaData=nextKinEntityRepository.save(nextKinEntity);
        return nextKinModelRepository.findByKinId(savaData.getKinId());
    }

    @Override
    public List<NextKinModel> getAllNextKins() {
        return nextKinModelRepository.findAll();
    }
}
