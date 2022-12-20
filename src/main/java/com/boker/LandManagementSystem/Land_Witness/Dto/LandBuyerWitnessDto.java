package com.boker.LandManagementSystem.Land_Witness.Dto;

import lombok.Data;

@Data
public class LandBuyerWitnessDto {
    private String landWitnessId;
    private String witnessFirstName;
    private String witnessLastName;
    private String witnessEmail;
    private String witnessPhoneNumber;
    private Long landOwnerId;
    private Long landBuyerId;
}
