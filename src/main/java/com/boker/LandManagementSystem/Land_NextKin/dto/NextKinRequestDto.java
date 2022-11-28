package com.boker.LandManagementSystem.Land_NextKin.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class NextKinRequestDto {
    private String firstName;
    private String middleName;
    private String surname;
    private Long ownerId;
    private Long buyerId;
    private String birthNo;
    private String IdNumber;
    private Long age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String relationshipType;

}
