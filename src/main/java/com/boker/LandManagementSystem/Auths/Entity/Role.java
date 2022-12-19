package com.boker.LandManagementSystem.Auths.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Entity
@Table(name = "roles")
public class Role {
    @Id
    private  String roleName;
    private  String roleDescription;
}
