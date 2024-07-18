package com.backend.vitalvibe.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "meals")
public class Meal {


    // VARIABLES
    @Id
    private String id;

    // användaren som reggar måltid
    private String userId;


    // typ av måltid = (frukost, lunch, middag, kvällsmat, snacks
    @NotBlank
    private String mealType;
    @NotBlank
    private String name;
    @NotNull
    private double amount;
    @NotNull
    private int calories;
    @CreatedDate
    private LocalDate date = LocalDate.now();


    // CONSTRUCTOR
    public Meal() {
    }


    // GETTERS
    public String getId() {
        return id;
    }
    public LocalDate getDate() {
        return date;
    }
    @NotNull
    public int getCalories() {
        return calories;
    }
    @NotNull
    public double getAmount() {
        return amount;
    }
    public @NotBlank String getName() {
        return name;
    }
    public @NotBlank String getMealType() {
        return mealType;
    }
    public String getUserId() {
        return userId;
    }


    // SETTERS
    public void setId(String id) {
        this.id = id;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setName(@NotBlank String name) {
        this.name = name;
    }
    public void setMealType(@NotBlank String mealType) {
        this.mealType = mealType;
    }
    public void setCalories(@NotNull int calories) {
        this.calories = calories;
    }
    public void setAmount(@NotNull double amount) {
        this.amount = amount;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
}
