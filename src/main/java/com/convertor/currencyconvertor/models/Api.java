package com.convertor.currencyconvertor.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.HashMap;


@Entity
public class Api {
    @Id
    private String base;
    private Date date;
    private String time_last_updated;
    private String rates;

    public Api(){}

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

    public String getRates() {
        return rates;
    }

    public void setRates(String rates) {
        this.rates = rates;
    }

    public HashMap<String, String> getRatesMap() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<HashMap<String,String>> typeRef = new TypeReference<HashMap<String,String>>() {};
        return mapper.readValue(rates, typeRef);
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
