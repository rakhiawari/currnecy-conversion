package com.convertor.currencyconvertor.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CurrencyConverterDAO {

    @Autowired
    public String init() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://api.exchangerate-api.com/v4/latest/USD";
        String jsonString = restTemplate.getForObject(resourceUrl, String.class);
        return jsonString;
    }
}
