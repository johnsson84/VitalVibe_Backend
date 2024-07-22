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
    private Double amount;
    private Integer calories;

    // GETTERS
    public String getMealType() {
        return mealType;
    }
    public Integer getCalories() {
        return calories;
    }
    public String getName() {
        return name;
    }
    public Double getAmount() {
        return amount;
    }

    // SETTERS
    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
    public void setCalories(Integer calories) {
        this.calories = calories;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public void setName(String name) {
        this.name = name;
    }
}
