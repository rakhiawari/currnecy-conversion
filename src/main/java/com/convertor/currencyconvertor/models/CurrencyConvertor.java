package com.convertor.currencyconvertor.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="currency")
public class CurrencyConvertor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String base;
    private Date date;
    private String time_last_updated;
    private String countryCode;
    private Double currencyRate;


    public CurrencyConvertor(String base, Date date, String time_last_updated, String key, Double value) {
        this.id = id;
        this.base = base;
        this.date = date;
        this.time_last_updated = time_last_updated;
        this.countryCode = key;
        this.currencyRate = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(Double currencyRate) {
        this.currencyRate = currencyRate;
    }
}
