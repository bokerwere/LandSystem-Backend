package com.boker.LandManagementSystem.Land_Owner.dto;
import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Commons.Gender;
import lombok.Data;

import java.util.UUID;

@Data
public class OwnerRequest {

    private UUID publicId;
    private String ownerId;
    private String firstName;
    private String  middleName;
    private String surname;
    private String  phoneNumber;
    private String  email;
    private Address address;
    private Gender gender;
    private  String nationality;
}
