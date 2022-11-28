package com.boker.LandManagementSystem.Land_Owner.dto;
import com.boker.LandManagementSystem.Commons.Address;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Id;

@Data
public class OwnerRequest {

    private Long ownerId;
    private String firstName;
    private String  middleName;
    private String surname;
    private String  phoneNumber;
    private String  email;
    private Address address;
}
