package com.convertor.currencyconvertor.services;

import com.convertor.currencyconvertor.dao.CurrencyConverterDAO;
import com.convertor.currencyconvertor.models.CurrencyApi;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Service
public class CurrencyApiEntryService {

    @Autowired
    CurrencyConverterDAO currencyConverterDAO;

    @PostConstruct
    public void init() {
        String result = currencyConverterDAO.init();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject;
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
                currencyConverterDAO.save(currencyApi);
            }
        } catch (ParseException | java.text.ParseException e) {
            e.printStackTrace();
        }
    }

}
