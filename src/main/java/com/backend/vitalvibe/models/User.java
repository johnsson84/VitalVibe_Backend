package com.backend.vitalvibe.models;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document(collection = "users")
public class User {
    @Id
    private String id;

    @NotBlank
    @Size(max = 15)
    private String username;

    @NotBlank
    @Size(max = 20)
    private String firstName;

    @NotBlank
    @Size(max = 20)
    private String lastName;

    @NotNull
    private Integer age;


    private Double vo2max;
    private String fivekm;
    private String tenkm;
    private String fifteenkm;
    private String halfmarathon;
    private String marathon;




    @NotBlank
    @Email
    @Indexed(unique = true)
    private String email;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    // role
     private Set<Role> roles = new HashSet<>();
    // ["ROLE_USER", "ROLE MODERATOR"]

    public User(String username, String email, String password, String firstName, String lastName, Integer age, Double vo2max) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.vo2max = vo2max;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getVo2max() {
        return vo2max;
    }

    public void setVo2max(Double vo2max) {
        this.vo2max = vo2max;
    }

    public String getFivekm() {
        return fivekm;
    }

    public void setFivekm(String fivekm) {
        this.fivekm = fivekm;
    }

    public String getTenkm() {
        return tenkm;
    }

    public void setTenkm(String tenkm) {
        this.tenkm = tenkm;
    }

    public String getFifteenkm() {
        return fifteenkm;
    }

    public void setFifteenkm(String fifteenkm) {
        this.fifteenkm = fifteenkm;
    }

    public String getHalfmarathon() {
        return halfmarathon;
    }

    public void setHalfmarathon(String halfmarathon) {
        this.halfmarathon = halfmarathon;
    }

    public String getMarathon() {
        return marathon;
    }

    public void setMarathon(String marathon) {
        this.marathon = marathon;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
