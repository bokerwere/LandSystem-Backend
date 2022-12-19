package com.boker.LandManagementSystem.Land_Details.model;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Commons.BaseEntity;
import com.boker.LandManagementSystem.Land_Buyer.model.LandBuyerModel;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "lands")
public class LandModel  extends BaseEntity {
    @Id
    @Column(name = "land_reg_no")
    private String landRegistrationNumber;
    @Column(name = "land_plot_no")
    private String landPlotNumber;
    @Column(name = "land_size")
    private String landSize;
    @Column(name = "original_owner_id")
    private Long ownerId;
    // @Column(name="buyer_id")
    // private Long buyerId;
    @Column(name = "land_desc")
    private String landDescription;
    @Column(name = "land_price")
    private BigDecimal landPrice;
    @Column(name = "reg_form_image")
    private String regFormImage;
    @Column(name = "land_sales_status")
    private String landSaleStatus;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "landRegistrationNumber")
    private List<LandBuyerModel>landBuyerModels;

}
