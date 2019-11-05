package com.convertor.currencyconvertor.DAO;

import com.convertor.currencyconvertor.models.ApiData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;



@Component
public class CurrencyConvertorDAO {


    @Autowired
    public ApiData init() {
        RestTemplate restTemplate = new RestTemplate();
        ApiData apiData = restTemplate.getForObject("https://api.exchangerate-api" +
                ".com/v4/latest/USD", ApiData.class);
        return apiData;
        }
}
