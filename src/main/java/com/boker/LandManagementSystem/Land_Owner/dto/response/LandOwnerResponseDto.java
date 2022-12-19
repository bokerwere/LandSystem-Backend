package com.boker.LandManagementSystem.Land_Owner.dto.response;

import com.boker.LandManagementSystem.Commons.Address;
import com.boker.LandManagementSystem.Commons.Gender;
import com.boker.LandManagementSystem.Land_Details.model.LandModel;
import com.boker.LandManagementSystem.Land_NextKin.model.NextKinModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Data
public class LandOwnerResponseDto {

    private UUID publicId;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime createdAt;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime updatedAt;
    private String ownerId;
    private String firstName;
    private String  middleName;
    private String surname;
    private String  phoneNumber;
    private String  email;
    private Address address;
    private List<NextKinModel> nextKin=new ArrayList<>();
    private Set<LandModel> landModel=new HashSet<>();
    private Gender gender;

}

