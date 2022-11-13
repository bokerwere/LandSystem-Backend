package com.boker.LandManagementSystem.NextKinDetail.dto;

import lombok.Data;
@Data
public class NextKinRequestDto {
    private String firstName;
    private String middleName;
    private String surname;
    private Long ownerId;
    private String BirthNo;
    private String IdNumber;
    private Long age;
    private String gender;

}
