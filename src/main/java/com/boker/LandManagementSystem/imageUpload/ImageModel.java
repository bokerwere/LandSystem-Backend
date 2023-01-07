package com.boker.LandManagementSystem.imageUpload;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "image_models")
@NoArgsConstructor
@Data
public class ImageModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "image_id")
    private Long id;
    private String imageName;
    private String imageType;
//    @Column(length = 500000000)
//    private byte[] picByte;

    private String imageUrl;


    public ImageModel(String imageName, String imageType, String imageUrl) {
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageUrl=imageUrl;
        //this.picByte = picByte;
    }

}
