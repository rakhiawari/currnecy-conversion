package com.convertor.currencyconvertor.services;

import com.convertor.currencyconvertor.dao.CurrencyConverterDAO;
import com.convertor.currencyconvertor.models.ConvertedCurrency;
import com.convertor.currencyconvertor.models.CurrencyApi;
import com.convertor.currencyconvertor.repository.CurrencyApiRepository;
import com.convertor.currencyconvertor.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CurrencyConverterService {


    @Autowired
    CurrencyConverterDAO currencyConverterDAO;

    @Autowired
    ConvertedCurrency convertedCurrency;

    @Autowired
    CurrencyRepository currencyRepository;

    public ConvertedCurrency convertCurrency(String from, String to, Double amount) {


        String base = "USD";
        CurrencyApi fromCurrency = currencyConverterDAO.findByCurrencyCode(from);
        CurrencyApi toCurrency = currencyConverterDAO.findByCurrencyCode(to);

        if (fromCurrency == null || toCurrency == null) {

            convertedCurrency = new ConvertedCurrency(from, to, amount, 0.0);
            currencyRepository.save(convertedCurrency);
            return convertedCurrency;

        } else if (from.equals(base)) {

            convertedCurrency = new ConvertedCurrency(from, to, amount, (toCurrency.getValue() * amount));
            currencyRepository.save(convertedCurrency);
            return convertedCurrency;

        } else if (to.equals(base)) {

            convertedCurrency = new ConvertedCurrency(from, to, amount, ((1 / fromCurrency.getValue()) * amount));
            currencyRepository.save(convertedCurrency);
            return convertedCurrency;

        } else {
            Double temp = 1 / fromCurrency.getValue();
            convertedCurrency = new ConvertedCurrency(from, to, amount, (temp * toCurrency.getValue()));
            currencyRepository.save(convertedCurrency);
            return convertedCurrency;

        }
    }
}
