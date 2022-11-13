package com.boker.LandManagementSystem.NextKinDetail.entity;

import com.boker.LandManagementSystem.Commons.BaseEntity;
import lombok.Data;

import javax.persistence.*;

@Data
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
    private Long ownerId;
    private String BirthNo;
    private String IdNumber;
    private Long age;
    private String gender;
}
