package com.convertor.currencyconvertor.services;

import com.convertor.currencyconvertor.models.Api;
import com.convertor.currencyconvertor.models.CurrencyConvertor;
import com.convertor.currencyconvertor.repository.CurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class CurrencyConvertorService {

    @Autowired
    private CurrencyRepository currencyRepository;

    private static final Logger log= LoggerFactory.getLogger(CurrencyConvertorService.class);

    public String convertCurrency(String from, String to, BigDecimal amount) {
        RestTemplate restTemplate = new RestTemplate();
        Api api = restTemplate.getForObject("https://api.exchangerate-api" +
                ".com/v4/latest/USD", Api.class);

        currencyRepository.save(api);
        return api.toString();
    }
}
