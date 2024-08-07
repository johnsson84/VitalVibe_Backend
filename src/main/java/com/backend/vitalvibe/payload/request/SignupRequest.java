package com.backend.vitalvibe.payload.request;

import jakarta.validation.constraints.*;

import java.util.Set;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(max = 20)
    private String firstName;

    @NotBlank
    @Size(max = 20)
    private String lastName;

    @NotNull
    private int age;
    private double weight;


    private double vo2max;
    private String fivekm;
    private String tenkm;
    private String fifteenkm;
    private String halfmarathon;
    private String marathon;

    private Set<String> roles;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public double getVo2max() {
        return vo2max;
    }

    public void setVo2max(double vo2max) {
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
