package com.boker.LandManagementSystem.Commons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    private String location;
    private String County;
    private  String town;
    private String physicalAddress;

}
