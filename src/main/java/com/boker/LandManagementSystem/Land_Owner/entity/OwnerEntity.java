package com.boker.LandManagementSystem.Land_Owner.entity;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Commons.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "owners")
public class OwnerEntity extends BaseEntity {
    @Id
    @Column(name = "owner_id")
    private Long ownerId;
    @Column(name="first_name")
    private String firstName;
    @Column(name="middle_name")
    private String  middleName;
    @Column(name = "sur_name")
    private String surname;
    @Column(name = "owner_phone_no")
    private String  phoneNumber;
    @Column(name = "owner_email")
    private String  email;
    @Embedded
    private Address address;
}
