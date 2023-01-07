package com.boker.LandManagementSystem.imageUpload;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ImageUploadServiceProcess {
    @Autowired
    private ImageRepository imageRepository;
    private static String FOLDER=System.getProperty("user.dir")+"/src/main/resources/Images";

    @SneakyThrows
    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles){

        Set<ImageModel>imageModels=new HashSet<>();
        for (MultipartFile file:multipartFiles){
            String filePath=FOLDER+file.getOriginalFilename();
            ImageModel imageModel=new ImageModel(file.getOriginalFilename(), file.getContentType(), filePath);
            //imageRepository.save(imageModel);
            file.transferTo(new File(filePath));
            imageModels.add(imageModel);
        }

        return imageModels;
    }
}
