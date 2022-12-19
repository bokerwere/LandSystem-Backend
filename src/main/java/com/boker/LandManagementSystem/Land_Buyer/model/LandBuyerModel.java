package com.boker.LandManagementSystem.Land_Buyer.model;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Commons.BaseEntity;
import com.boker.LandManagementSystem.Commons.Gender;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import com.boker.LandManagementSystem.Land_NextKin.model.NextKinModel;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "land_buyers")
public class LandBuyerModel extends BaseEntity implements Serializable {
    @Id
    @Column(name = "buyer_id_no",unique = true,nullable = false)
    private String buyerId;
    @Column(name = "land_reg_no")
    private String landRegistrationNumber;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "b_gender_type")
    private Gender gender;
    @Column(name="b_nationality")
    private  String nationality;
    @Embedded
    private Address address;
    @OneToMany(targetEntity =NextKinModel.class,mappedBy = "buyerId" ,cascade=CascadeType.ALL)
    List<NextKinModel> nextKinModelList;

}
