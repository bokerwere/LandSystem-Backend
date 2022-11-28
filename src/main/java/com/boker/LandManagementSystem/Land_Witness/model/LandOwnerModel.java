package com.boker.LandManagementSystem.Land_Witness.model;

import com.boker.LandManagementSystem.Commons.BaseEntity;
import lombok.Data;

import javax.persistence.*;



@Data
@Entity
@Table(name = "land_witness")
public class LandOwnerModel extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "land_witness_id")
    private Long landWitnessId;
    @Column(name = "witness_first_name")
    private String witnessFirstName;
    @Column(name = "witness_last_name")
    private String witnessLastName;
    @Column(name = "witness_email")
    private String witnessEmail;
    @Column(name = "witness_phone_number")
    private String witnessPhoneNumber;
    //   Foreign key referencing land Owners
    @Column(name = "land_owner_id")
    private Long landOwnerId;
    //   Foreign key referencing land Buyer
    @Column(name = "land_buyer_id")
    private Long landBuyerId;
    @Column(name = "land_reg_number")
    private String landRegistrationNumber;

}
