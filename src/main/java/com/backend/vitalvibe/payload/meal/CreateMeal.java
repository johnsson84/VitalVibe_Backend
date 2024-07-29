package com.backend.vitalvibe.payload.meal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;

public class CreateMeal {

    /*
    Quick help for Postman

    {
    "userId": "String",
    "mealType": "String",
    "content": "arrayList",
    "calories": "integer"
    }

    */





    // DTO VARIABLES
    @NotBlank
    private String userId;

    @NotBlank
    private String mealType;

    @NotNull
    private ArrayList content;
    @NotNull
    private int calories;

    // GETTERS
    @NotBlank
    public String getUserId() {
        return userId;
    }
    @NotBlank
    public  String getMealType() {
        return mealType;
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


    public void setCalories(@NotNull int calories) {
        this.calories = calories;
    }

    public ArrayList getContent() {
        return content;
    }

    public void setContent(ArrayList content) {
        this.content = content;
    }
}
