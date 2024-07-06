package com.backend.vitalvibe.payload.user;

import jakarta.validation.constraints.Email;

public class UpdateUser {

    private String firstName;
    private String lastName;
    private Double vo2max;
    @Email
    private String email;
    private String fivekm;
    private String tenkm;
    private String fifteenkm;
    private String halfmarathon;
    private String marathon;
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
