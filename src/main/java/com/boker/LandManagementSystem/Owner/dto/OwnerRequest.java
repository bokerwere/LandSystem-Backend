package com.boker.LandManagementSystem.Owner.dto;
import lombok.Data;
@Data
public class OwnerRequest {
    private String firstName;
    private String  middleName;
    private String surname;
    private Long idNumber;
    private String plotNumber;
    private  String blockNumber;
    private String Location;
    private String phoneNumber;

}
