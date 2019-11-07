package com.convertor.currencyconvertor.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class ConvertedCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Integer id;

    private String convertFrom;
    private String convertTo;
    private Double amountToConvert;
    private Double convertedAmount;

    public ConvertedCurrency(){}
    public ConvertedCurrency(String convertFrom, String convertTo, Double amountToConvert,
                             Double convertedAmount) {

        this.convertFrom = convertFrom;
        this.convertTo = convertTo;
        this.amountToConvert = amountToConvert;
        this.convertedAmount = convertedAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConvertFrom() {
        return convertFrom;
    }

    public void setConvertFrom(String convertFrom) {
        this.convertFrom = convertFrom;
    }

    public String getConvertTo() {
        return convertTo;
    }

    public void setConvertTo(String convertTo) {
        this.convertTo = convertTo;
    }

    public Double getAmountToConvert() {
        return amountToConvert;
    }

    public void setAmountToConvert(Double amountToConvert) {
        this.amountToConvert = amountToConvert;
    }

    public Double getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(Double convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
