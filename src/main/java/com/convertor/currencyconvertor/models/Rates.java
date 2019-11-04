package com.convertor.currencyconvertor.models;

public class Rates {
    private String countryCode;
    private String rate;

    public Rates(){}
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
