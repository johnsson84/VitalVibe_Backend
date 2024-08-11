package com.backend.vitalvibe.models;

public class RunningResults {

    // ================================================
    // VARIABLES
    private Integer fivekm = 0;
    private Integer tenkm = 0;
    private Integer fifteenkm = 0;
    private Integer halfmarathon= 0;
    private Integer marathon = 0;

    // ================================================
    // CONSTRUCTORS
    public RunningResults() {
    }

    // ================================================
    // GETTERS & SETTERS
    public Integer getFivekm() {
        return fivekm;
    }

    public void setFivekm(Integer fivekm) {
        this.fivekm = fivekm;
    }

    public Integer getTenkm() {
        return tenkm;
    }

    public void setTenkm(Integer tenkm) {
        this.tenkm = tenkm;
    }

    public Integer getFifteenkm() {
        return fifteenkm;
    }

    public void setFifteenkm(Integer fifteenkm) {
        this.fifteenkm = fifteenkm;
    }

    public Integer getHalfmarathon() {
        return halfmarathon;
    }

    public void setHalfmarathon(Integer halfmarathon) {
        this.halfmarathon = halfmarathon;
    }

    public Integer getMarathon() {
        return marathon;
    }

    public void setMarathon(Integer marathon) {
        this.marathon = marathon;
    }
}
