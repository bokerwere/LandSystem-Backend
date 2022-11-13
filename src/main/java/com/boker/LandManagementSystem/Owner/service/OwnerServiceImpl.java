package com.boker.LandManagementSystem.Owner.service;
import com.boker.LandManagementSystem.Owner.dto.OwnerRequest;
import com.boker.LandManagementSystem.Owner.entity.OwnerEntity;
import com.boker.LandManagementSystem.Owner.model.OwnerModel;
import com.boker.LandManagementSystem.Owner.repository.OwnerEntityRepository;
import com.boker.LandManagementSystem.Owner.repository.OwnerModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService{
    private  final OwnerEntityRepository ownerEntityRepository;
    private final OwnerModelRepository ownerModelRepository;

    @Override
    public OwnerModel createOwner(OwnerRequest ownerRequest) {
        OwnerEntity ownerEntity =new OwnerEntity();
        ownerEntity.setBlockNumber(ownerRequest.getBlockNumber());
        ownerEntity.setFirstName(ownerRequest.getFirstName());
        ownerEntity.setMiddleName(ownerRequest.getMiddleName());
        ownerEntity.setSurname(ownerRequest.getSurname());
        ownerEntity.setIdNumber(ownerRequest.getIdNumber());
        ownerEntity.setPlotNumber(ownerRequest.getPlotNumber());
        ownerEntity.setLocation(ownerRequest.getLocation());
        ownerEntity.setPhoneNumber(ownerRequest.getPhoneNumber());
        OwnerEntity saverOwner=ownerEntityRepository.save(ownerEntity);
        return  ownerModelRepository.findByOwnerId(saverOwner.getOwnerId());
    }

    @Override
    public List<OwnerModel> getAllOwners() {
        return ownerModelRepository.findAll();
    }
}
