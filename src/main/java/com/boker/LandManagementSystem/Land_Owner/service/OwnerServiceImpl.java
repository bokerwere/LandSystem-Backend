package com.boker.LandManagementSystem.Land_Owner.service;
import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Land_Owner.dto.OwnerRequest;
import com.boker.LandManagementSystem.Land_Owner.entity.OwnerEntity;
import com.boker.LandManagementSystem.Land_Owner.model.OwnerModel;
import com.boker.LandManagementSystem.Land_Owner.repository.OwnerEntityRepository;
import com.boker.LandManagementSystem.Land_Owner.repository.OwnerModelRepository;
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
        ownerEntity.setOwnerId(ownerRequest.getOwnerId());
        ownerEntity.setFirstName(ownerRequest.getFirstName());
        ownerEntity.setMiddleName(ownerRequest.getMiddleName());
        ownerEntity.setSurname(ownerRequest.getSurname());
        ownerEntity.setEmail(ownerRequest.getEmail());
        ownerEntity.setPhoneNumber(ownerRequest.getPhoneNumber());
        ownerEntity.setAddress(new Address(ownerRequest.getAddress().getCounty(),ownerRequest.getAddress().getLocation(),ownerRequest.getAddress().getTown(),ownerRequest.getAddress().getPhysicalAddress()));
        OwnerEntity saverOwner=ownerEntityRepository.save(ownerEntity);
        return  ownerModelRepository.findByOwnerId(saverOwner.getOwnerId());
    }

    @Override
    public List<OwnerModel> getAllOwners() {
        return ownerModelRepository.findAll();
    }
}
