package com.backend.vitalvibe.payload.meal;

import java.util.ArrayList;

public class UpdateMeal {

    /*
     Quick help for Postman
    {
     "mealType": "String",
     "name": "String",
     "amount": "double";
     "calories": "integer"
     }

    * */


    private String mealType;
    private ArrayList content;
    private Integer calories;

    // GETTERS
    public String getMealType() {
        return mealType;
    }
    public Integer getCalories() {
        return calories;
    }



    // SETTERS
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
    public void setCalories(Integer calories) {
        this.calories = calories;
    }


    public ArrayList getContent() {
        return content;
    }

    public void setContent(ArrayList content) {
        this.content = content;
    }
}
