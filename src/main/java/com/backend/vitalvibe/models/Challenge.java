package com.backend.vitalvibe.models;


import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "challenges")
public class Challenge {

    // id
    @Id
    private String id;

    // distance ( String för att kunna ange intervall-pass)
    @NotBlank
    private String distance;




    private LocalDateTime startingDate = LocalDateTime.now();

    // enddate
    // nedräknande klocka i frontend
    private LocalDateTime endDate;

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }



    public String getId() {
        return id;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
