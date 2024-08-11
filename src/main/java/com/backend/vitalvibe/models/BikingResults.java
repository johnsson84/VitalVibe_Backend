package com.backend.vitalvibe.models;

public class BikingResults {

    // pwt = Power-To-Weight
    // Formel = watt/vikt
    // Exempel = En person som väger 70kg cyklar 1 timme, via sin "watt mätare till cykel" får han fram att han
    // producerade 350 watt. Hans pwt_60min blir 350/70 = 5 W/kg.

    // ================================================
    // VARIABLES
    private Double ptw_5s = 0.0;
    private Double ptw_60s = 0.0;
    private Double ptw_5min = 0.0;
    private Double ptw_60min = 0.0;

    // ================================================
    // CONSTRUCTORS
    public BikingResults() {
    }

    // ================================================
    // GETTERS & SETTERS
    public Double getPtw_5s() {
        return ptw_5s;
    }

    public void setPtw_5s(Double ptw_5s) {
        this.ptw_5s = ptw_5s;
    }

    public Double getPtw_60s() {
        return ptw_60s;
    }

    public void setPtw_60s(Double ptw_60s) {
        this.ptw_60s = ptw_60s;
    }

    public Double getPtw_5min() {
        return ptw_5min;
    }

    public void setPtw_5min(Double ptw_5min) {
        this.ptw_5min = ptw_5min;
    }

    public Double getPtw_60min() {
        return ptw_60min;
    }

    public void setPtw_60min(Double ptw_60min) {
        this.ptw_60min = ptw_60min;
    }
}
