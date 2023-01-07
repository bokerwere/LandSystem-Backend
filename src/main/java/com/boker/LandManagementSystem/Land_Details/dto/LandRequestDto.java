package com.boker.LandManagementSystem.Land_Details.dto;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.imageUpload.ImageModel;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embedded;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

@Data
public class LandRequestDto {
    private UUID publicId;
    //private Long landRegistrationNumber;
    private String landPlotNumber;
    private String landSize;
    private Long ownerId;
    private String landDescription;
    private BigDecimal landPrice;
    private String landSaleStatus;
    private String regFormImage;
    private Address address;

}

