package com.convertor.currencyconvertor.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class CurrencyConvertor {
    @Id
    private String id;
    private String from;
    private String to;
    private BigDecimal amount;
    private BigDecimal convertedAmount;

    public CurrencyConvertor(String id, String from, String to, BigDecimal amount, BigDecimal convertedAmount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.convertedAmount = convertedAmount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getConvertedAmount() {
        return convertedAmount;
    }

    public void setConvertedAmount(BigDecimal convertedAmount) {
        this.convertedAmount = convertedAmount;
    }
}
