package com.example.covid19.models1;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Country{
    @JsonProperty("ID")
    public String iD;
    @JsonProperty("Country")
    public String country;
    @JsonProperty("CountryCode")
    public String countryCode;
    @JsonProperty("Slug")
    public String slug;
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
    @JsonProperty("Premium")
    public Premium premium;

    @Override
    public String toString() {
        return "Country{" +
                "iD='" + iD + '\'' +
                ", country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", slug='" + slug + '\'' +
                ", newConfirmed=" + newConfirmed +
                ", totalConfirmed=" + totalConfirmed +
                ", newDeaths=" + newDeaths +
                ", totalDeaths=" + totalDeaths +
                ", newRecovered=" + newRecovered +
                ", totalRecovered=" + totalRecovered +
                ", date=" + date +
                ", premium=" + premium +
                '}';
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
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

    public Premium getPremium() {
        return premium;
    }

    public void setPremium(Premium premium) {
        this.premium = premium;
    }
}
