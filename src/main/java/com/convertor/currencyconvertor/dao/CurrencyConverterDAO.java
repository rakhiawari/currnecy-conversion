package com.convertor.currencyconvertor.dao;

import com.convertor.currencyconvertor.models.CurrencyApi;
import com.convertor.currencyconvertor.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CurrencyConverterDAO {

    @Autowired
    private CurrencyRepository currencyRepository;
    public String init() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://api.exchangerate-api.com/v4/latest/USD";
        String jsonString = restTemplate.getForObject(resourceUrl, String.class);
        return jsonString;
    }
    public void save(CurrencyApi currencyApi){
        currencyRepository.save(currencyApi);
    }
    public CurrencyApi findByCurrencyCode(String search){
        return currencyRepository.findByCurrencyCode(search);
    }
}
