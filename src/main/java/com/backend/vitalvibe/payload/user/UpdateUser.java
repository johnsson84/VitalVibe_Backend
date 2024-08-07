package com.backend.vitalvibe.payload.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.springframework.data.mongodb.core.index.Indexed;

public class UpdateUser {
    @Size(max = 20)
    private String firstName;
    @Size(max = 20)
    private String lastName;
    private Double vo2max;
    @Email
    @Indexed(unique = true)
    private String email;
    private Integer themeColor;
    @Size(min = 6, max = 40)
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

    public Integer getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(Integer themeColor) {
        this.themeColor = themeColor;
    }
}
