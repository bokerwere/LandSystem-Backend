package com.boker.LandManagementSystem.Land_Buyer.dto;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Commons.Gender;
import lombok.Data;

import javax.persistence.Column;

@Data
public class LandBuyerDto {
    private String buyerId;
    private String firstName;
    private String  middleName;
    private String surname;
    private String  phoneNumber;
    private String  email;
    private Gender gender;
    private  String nationality;
    private Address address;
    private String landRegistrationNumber;

}
