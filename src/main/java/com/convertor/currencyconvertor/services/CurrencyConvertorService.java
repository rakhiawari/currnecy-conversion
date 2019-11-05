package com.convertor.currencyconvertor.services;

import com.convertor.currencyconvertor.DAO.CurrencyConvertorDAO;
import com.convertor.currencyconvertor.models.ApiData;
import com.convertor.currencyconvertor.models.CurrencyConvertor;
import com.convertor.currencyconvertor.repository.CurrencyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class CurrencyConvertorService {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    ApiData apiData;
    @Autowired
    CurrencyConvertorDAO currencyConvertorDAO;


    @PostConstruct
    public void init() {

        apiData = currencyConvertorDAO.init();

        for (Map.Entry<String, Double> entry : apiData.getRates().entrySet()) {

            CurrencyConvertor object = new CurrencyConvertor(apiData.getBase(), apiData.getDate(),
                    apiData.getTime_last_updated(), entry.getKey(), entry.getValue());
            currencyRepository.save(object);
        }

    }

    public String convertCurrency(String from, String to, BigDecimal amount) {
        return null;
    }
}
