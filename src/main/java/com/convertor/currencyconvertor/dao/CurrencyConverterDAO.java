package com.convertor.currencyconvertor.dao;

import com.convertor.currencyconvertor.models.CurrencyApi;
import com.convertor.currencyconvertor.repository.CurrencyApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CurrencyConverterDAO {

    @Autowired
    private CurrencyApiRepository currencyApiRepository;
    public String init() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "https://api.exchangerate-api.com/v4/latest/USD";
        String jsonString = restTemplate.getForObject(resourceUrl, String.class);
        return jsonString;
    }
    public void save(CurrencyApi currencyApi){
        currencyApiRepository.save(currencyApi);
    }
    public CurrencyApi findByCurrencyCode(String search){
        return currencyApiRepository.findByCurrencyCode(search);
    }
}
