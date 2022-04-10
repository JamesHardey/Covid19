package com.example.covid19.models1;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Global{
    @JsonProperty("NewConfirmed")
    public long newConfirmed;
    @JsonProperty("TotalConfirmed")
    public long totalConfirmed;
    @JsonProperty("NewDeaths")
    public long newDeaths;
    @JsonProperty("TotalDeaths")
    public long totalDeaths;
    @JsonProperty("NewRecovered")
    public long newRecovered;
    @JsonProperty("TotalRecovered")
    public long totalRecovered;
    @JsonProperty("Date")
    public Date date;

    @Override
    public String toString() {
        return "Global{" +
                "newConfirmed=" + newConfirmed +
                ", totalConfirmed=" + totalConfirmed +
                ", newDeaths=" + newDeaths +
                ", totalDeaths=" + totalDeaths +
                ", newRecovered=" + newRecovered +
                ", totalRecovered=" + totalRecovered +
                ", date=" + date +
                '}';
    }

    public long getNewConfirmed() {
        return newConfirmed;
    }

    public void setNewConfirmed(long newConfirmed) {
        this.newConfirmed = newConfirmed;
    }

    public long getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(long totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

    public long getNewDeaths() {
        return newDeaths;
    }

    public void setNewDeaths(long newDeaths) {
        this.newDeaths = newDeaths;
    }

    public long getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(long totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public long getNewRecovered() {
        return newRecovered;
    }

    public void setNewRecovered(long newRecovered) {
        this.newRecovered = newRecovered;
    }

    public long getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(long totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}