package com.boker.LandManagementSystem.Land_Owner.entity;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Commons.BaseEntity;
import com.boker.LandManagementSystem.Commons.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "land_owners")
public class OwnerEntity extends BaseEntity {
    @Id
    @Column(name = "owner_owner_id")
    private String ownerId;
    @Column(name="owner_first_name")
    private String firstName;
    @Column(name="owner_middle_name")
    private String  middleName;
    @Column(name = "owner_sur_name")
    private String surname;
    @Column(name = "owner_phone_no")
    private String  phoneNumber;
    @Column(name = "owner_email")
    private String  email;
    @Column(name="owner_nationality")
    private  String nationality;
    @Embedded
    private Address address;
    @Enumerated(EnumType.STRING)
    @Column(name="owner_gender")
    private Gender gender;
}
