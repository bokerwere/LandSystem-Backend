package com.boker.LandManagementSystem.Auths.Entity;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String email;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns =
            {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Collection<Role> userRole = new ArrayList<>();

}
