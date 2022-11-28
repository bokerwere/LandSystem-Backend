package com.boker.LandManagementSystem.Land_Buyer.entity;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Commons.BaseEntity;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name="land_buyers")
public class LandBuyerEntity extends BaseEntity {
    @Id
    @Column(name = "buyer_id_no")
    private Long buyerId;
    @Column(name="b_first_name")
    private String firstName;
    @Column(name="b_middle_name")
    private String  middleName;
    @Column(name = "b_surname")
    private String surname;
    @Column(name = "b_phone_no")
    private String  phoneNumber;
    @Column(name = "b_email")
    private String  email;
    @Embedded
    private Address address;

}
