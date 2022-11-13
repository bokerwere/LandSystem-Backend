package com.boker.LandManagementSystem.Owner.service;

import com.boker.LandManagementSystem.Owner.dto.OwnerRequest;
import com.boker.LandManagementSystem.Owner.model.OwnerModel;
import java.util.List;

public interface OwnerService {
    OwnerModel createOwner(OwnerRequest ownerRequest);
    List<OwnerModel>getAllOwners();
    //OwnerEntity update(OwnerRequest ownerRequest);


}
