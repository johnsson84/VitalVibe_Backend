package com.backend.vitalvibe.payload.activity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateActivity {

    // VARIABLES
    @NotBlank
    private String activityName;

    @NotNull
    private Double distance;

    @NotNull
    private Double time;

    // Not necessary
    private Integer calories;

    @NotBlank
    private String mood;

    // GETTERS & SETTERS

    public @NotBlank String getActivityName() {
        return activityName;
    }

    public void setActivityName(@NotBlank String activityName) {
        this.activityName = activityName;
    }

    public @NotNull Double getDistance() {
        return distance;
    }

    public void setDistance(@NotNull Double distance) {
        this.distance = distance;
    }

    public @NotNull Double getTime() {
        return time;
    }

    public void setTime(@NotNull Double time) {
        this.time = time;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public @NotBlank String getMood() {
        return mood;
    }

    public void setMood(@NotBlank String mood) {
        this.mood = mood;
    }
}
