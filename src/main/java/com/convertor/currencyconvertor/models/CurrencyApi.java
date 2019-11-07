package com.convertor.currencyconvertor.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class CurrencyApi {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String base;
    private Date date;
    private String time_last_updated;
    private String currencyCode;
    private Double value;

    public CurrencyApi() {
    }

    public CurrencyApi(String base, Date date, String time_last_updated, String currencyCode,
                       Double value) {
        this.base = base;
        this.date = date;
        this.time_last_updated = time_last_updated;
        this.currencyCode = currencyCode;
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}
