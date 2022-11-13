package com.boker.LandManagementSystem.Owner.entity;

import com.boker.LandManagementSystem.Commons.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Data
@Entity
@Table(name = "owners")
public class OwnerEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="owner_id")
    @JsonIgnore
    private Long ownerId;
    private String firstName;
    private String  middleName;
    private String surname;
    @NaturalId
    private Long idNumber;
    private String plotNumber;
    private String  phoneNumber;
    private  String blockNumber;
    private String Location;

}
