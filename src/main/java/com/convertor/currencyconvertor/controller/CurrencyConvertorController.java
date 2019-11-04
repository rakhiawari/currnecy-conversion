package com.convertor.currencyconvertor.controller;

import com.convertor.currencyconvertor.models.Api;
import com.convertor.currencyconvertor.models.CurrencyConvertor;
import com.convertor.currencyconvertor.services.CurrencyConvertorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RestController
@RequestMapping("/convertor")
public class CurrencyConvertorController {

    @Autowired
    CurrencyConvertorService currencyConvertorService;

    @RequestMapping("/{from}/{to}/{amount}")
    public String convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to,
                               @PathVariable("amount") BigDecimal amount) {

        return currencyConvertorService.convertCurrency(from, to, amount);

    }
}
