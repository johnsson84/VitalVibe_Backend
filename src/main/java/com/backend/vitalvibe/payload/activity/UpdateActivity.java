package com.backend.vitalvibe.payload.activity;

/* Quick help Postman
    {
        "acitivityName": "String",
        "distance": double,
        "time": double,
        "calories": int,
        "mood": "String
    }
    * */

public class UpdateActivity {

    private String id;

    private String activityName;

    private Double distance;

    private Double time;

    private Integer calories;

    private String mood;


    // GETTERS & SETTERS


    public String getId() {
        return id;
    }

    public void setId(String id) {
        id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
