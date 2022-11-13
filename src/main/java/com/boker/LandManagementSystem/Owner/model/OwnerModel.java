package com.boker.LandManagementSystem.Owner.model;

import com.boker.LandManagementSystem.Commons.BaseEntity;
import com.boker.LandManagementSystem.NextKinDetail.entity.NextKinEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table(name = "owners")
public class OwnerModel  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "owner_id")
    @JsonIgnore
    private Long ownerId;
    private String firstName;
    private String  middleName;
    private String surname;
    private String idNumber;
    private String plotNumber;
    private  String blockNumber;
    private String Location;
    private String  phoneNumber;
    @OneToMany(targetEntity = NextKinEntity.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "ownerId")
    //@JoinColumn(name = "owner_id",referencedColumnName = "id",updatable = true)
    private List<NextKinEntity> nextKin=new ArrayList<>();
}
