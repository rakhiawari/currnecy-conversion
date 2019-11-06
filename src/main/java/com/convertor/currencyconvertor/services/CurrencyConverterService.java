package com.convertor.currencyconvertor.services;

import com.convertor.currencyconvertor.dao.CurrencyConverterDAO;
import com.convertor.currencyconvertor.models.CurrencyApi;
import com.convertor.currencyconvertor.repository.CurrencyRepository;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


@Service
public class CurrencyConverterService {


    @Autowired
    CurrencyConverterDAO currencyConverterDAO;
    @Autowired
    CurrencyRepository currencyRepository;

    @PostConstruct
    public void init() {
        String result = currencyConverterDAO.init();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {
            jsonObject = (JSONObject) parser.parse(result);
            String base = (String) jsonObject.get("base");
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date = simpleDateFormat.parse(jsonObject.get("date").toString());
            String time_last_updated = jsonObject.get("time_last_updated").toString();
            JSONObject rates = (JSONObject) jsonObject.get("rates");
            Set<String> set = rates.keySet();
            for (String s : set) {
                String value = rates.get(s).toString();
                CurrencyApi currencyApi = new CurrencyApi(base, date, time_last_updated, s, Double.parseDouble(value));
                currencyRepository.save(currencyApi);
            }
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
    }

    public Double convertCurrency(String from, String to, Double amount) {

        String base = "USD";
        if (currencyRepository.findByCurrencyCode(from) == null || currencyRepository.findByCurrencyCode(to) == null) {
            return 0.0;
        } else if (from.equals(base)) {

            CurrencyApi currency = currencyRepository.findByCurrencyCode(to);
            return (currency.getValue() * amount);

        } else if (to.equals(base)) {

            CurrencyApi currency = currencyRepository.findByCurrencyCode(from);
            return ((1 / currency.getValue()) * amount);

        } else {

            CurrencyApi fromCurrency = currencyRepository.findByCurrencyCode(from);
            CurrencyApi toCurrency = currencyRepository.findByCurrencyCode(to);
            Double temp = 1 / fromCurrency.getValue();
            return (temp * toCurrency.getValue());
        }
    }
}
