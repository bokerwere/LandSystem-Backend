package com.boker.LandManagementSystem.Land_Witness.Dto;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Data
@Builder
public class LandOwnerDto {
    private Long landWitnessId;
    private String witnessFirstName;
    private String witnessLastName;
    private String witnessEmail;
    private String witnessPhoneNumber;
    private Long landOwnerId;
    private Long landBuyerId;
    private String landRegistrationNumber;
}
