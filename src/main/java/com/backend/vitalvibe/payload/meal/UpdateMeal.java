package com.backend.vitalvibe.payload.meal;

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
    private String name;
    private double amount;
    private int calories;

    // GETTERS
    public String getMealType() {
        return mealType;
    }
    public int getCalories() {
        return calories;
    }
    public String getName() {
        return name;
    }
    public double getAmount() {
        return amount;
    }

    // SETTERS
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setName(String name) {
        this.name = name;
    }
}
