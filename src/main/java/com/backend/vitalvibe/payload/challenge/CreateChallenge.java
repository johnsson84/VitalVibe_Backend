package com.backend.vitalvibe.payload.challenge;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CreateChallenge {

    // distance ( String för att kunna ange intervall-pass)
    @NotBlank
    private String distance;


    // enddate
    // nedräknande klocka i frontend
    @NotNull
    private int endDate;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
}
