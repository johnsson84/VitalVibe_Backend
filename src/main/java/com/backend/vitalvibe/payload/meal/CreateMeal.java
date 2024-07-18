package com.backend.vitalvibe.payload.meal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateMeal {

    // DTO VARIABLES
    @NotBlank
    private String userId;

    @NotBlank
    private String mealType;
    @NotBlank
    private String name;
    @NotNull
    private double amount;
    @NotNull
    private int calories;

    // GETTERS
    public @NotBlank String getUserId() {
        return userId;
    }
    public @NotBlank String getMealType() {
        return mealType;
    }
    public @NotBlank String getName() {
        return name;
    }
    @NotNull
    public double getAmount() {
        return amount;
    }
    @NotNull
    public int getCalories() {
        return calories;
    }


    // SETTERS
    public void setUserId(@NotBlank String userId) {
        this.userId = userId;
    }
    public void setMealType(@NotBlank String mealType) {
        this.mealType = mealType;
    }
    public void setName(@NotBlank String name) {
        this.name = name;
    }
    public void setAmount(@NotNull double amount) {
        this.amount = amount;
    }
    public void setCalories(@NotNull int calories) {
        this.calories = calories;
    }
}
