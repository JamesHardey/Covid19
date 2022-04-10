package com.example.covid19.models1;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Root{
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("Message")
    public String message;
    @JsonProperty("Global")
    public Global global;
    @JsonProperty("Countries")
    public List<Country> countries;
    @JsonProperty("Date")
    public Date date;

    @Override
    public String toString() {
        return "Root{" +
                "iD='" + iD + '\'' +
                ", message='" + message + '\'' +
                ", global=" + global +
                ", countries=" + countries +
                ", date=" + date +
                '}';
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Global getGlobal() {
        return global;
    }

    public void setGlobal(Global global) {
        this.global = global;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}