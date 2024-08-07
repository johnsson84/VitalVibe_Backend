package com.backend.vitalvibe.payload.user;

public class UpdateRunningResults {

    // Från hemsidan skickar man i sekunder.

    private Integer fivekm;
    private Integer tenkm;
    private Integer fifteenkm;
    private Integer halfmarathon;
    private Integer marathon;

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
