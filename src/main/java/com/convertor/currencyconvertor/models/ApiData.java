package com.convertor.currencyconvertor.models;

import java.util.Date;
import java.util.Map;

public class ApiData {

    private String base;
    private Date date;
    private String time_last_updated;
    private Map<String,Double> rates;

    public ApiData(){}

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime_last_updated() {
        return time_last_updated;
    }

    public void setTime_last_updated(String time_last_updated) {
        this.time_last_updated = time_last_updated;
    }

    public Map<String,Double> getRates() {
        return rates;
    }

    public void setRates(Map<String,Double> rates) {
        this.rates = rates;
    }


    @Override
    public String toString() {
        return "Api{" +
                "base='" + base + '\'' +
                ", date=" + date +
                ", time_last_updated='" + time_last_updated + '\'' +
                ", rates=" + rates +
                '}';
    }
}
