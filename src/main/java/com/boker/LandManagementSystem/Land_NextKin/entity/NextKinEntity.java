package com.boker.LandManagementSystem.Land_NextKin.entity;

import com.boker.LandManagementSystem.Commons.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "next_kins")
public class NextKinEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "kin_id")
    private Long kinId;
    private String firstName;
    private String middleName;
    private String surname;
    @Column(name = "owner_id")
    private String ownerId;
    @Column(name = "buyer_id_no")
    private String buyerId;
    private String BirthNo;
    private String IdNumber;
    private Long age;
    private String gender;
    private String phoneNumber;
    private String email;
    private String relationshipType;
}
