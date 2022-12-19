package com.boker.LandManagementSystem.Commons;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    private String location;
    private String County;
    private String town;
    private String physicalAddress;

}
