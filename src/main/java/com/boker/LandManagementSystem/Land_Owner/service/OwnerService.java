package com.boker.LandManagementSystem.Land_Owner.service;

import com.boker.LandManagementSystem.Land_Owner.dto.OwnerRequest;
import com.boker.LandManagementSystem.Land_Owner.model.OwnerModel;
import java.util.List;

public interface OwnerService {
    OwnerModel createOwner(OwnerRequest ownerRequest);
    List<OwnerModel>getAllOwners();
    //OwnerEntity update(OwnerRequest ownerRequest);


}
