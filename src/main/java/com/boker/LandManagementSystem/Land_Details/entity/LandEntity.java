package com.boker.LandManagementSystem.Land_Details.entity;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Commons.BaseEntity;
import com.boker.LandManagementSystem.imageUpload.ImageModel;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Data
@Entity
@Table(name = "lands")
public class LandEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "land_reg_no")
    private Long landRegistrationNumber;
    @Column(name = "land_plot_no")
    private String landPlotNumber;
    @Column(name = "land_size")
    private String landSize;
    @Column(name = "original_owner_id")
    private Long ownerId;
    @Column(name = "land_desc")
    private String landDescription;
    @Column(name = "land_price")
    private BigDecimal landPrice;
    @Column(name = "land_sales_status")
    private String landSaleStatus;
    @Column(name = "reg_form_image")
    private String regFormImage;
    @Embedded
    private Address address;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "images", joinColumns = {@JoinColumn(name = "land_reg_no")},
            inverseJoinColumns = {@JoinColumn(name = "image_id")})
    private Set<ImageModel> landImages;


}
