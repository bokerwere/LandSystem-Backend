package com.boker.LandManagementSystem.Land_Owner.model;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Commons.BaseEntity;
import com.boker.LandManagementSystem.Commons.Gender;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import com.boker.LandManagementSystem.Land_NextKin.model.NextKinModel;
import com.boker.LandManagementSystem.Land_Owner.dto.response.LandOwnerResponseDto;
import com.boker.LandManagementSystem.Land_Witness.model.LandWitnessModel;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "land_owners")
public class OwnerModel extends BaseEntity {
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
    @OneToMany(targetEntity = NextKinModel.class, cascade = CascadeType.ALL, mappedBy = "ownerId")
    //@JoinColumn(name = "owner_id",referencedColumnName = "id",updatable = true)
    private List<NextKinModel> nextKin = new ArrayList<>();
    @OneToMany(targetEntity = LandModel.class, cascade = CascadeType.ALL, mappedBy = "ownerId")
    private Set<LandModel> landModel = new HashSet<>();
    @OneToMany(mappedBy = "landOwnerId")
    private List<LandWitnessModel> landWitnessModelList;

}
