package com.boker.LandManagementSystem.Land_Buyer.dto;

import com.boker.LandManagementSystem.Commons.Address;
import lombok.Data;

@Data
public class LandBuyerDto {
    private Long buyerId;
    private String firstName;
    private String  middleName;
    private String surname;
    private String  phoneNumber;
    private String  email;
    private Address address;
}
