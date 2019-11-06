package com.convertor.currencyconvertor.controller;

import com.convertor.currencyconvertor.services.CurrencyConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class CurrencyConverterController {

    @Autowired
    CurrencyConverterService currencyConverterService;

    @GetMapping("from/{from}/to/{to}/{amount}")
    public Double convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to,
                                  @PathVariable("amount") Double amount) {
        return currencyConverterService.convertCurrency(from, to, amount);
    }
}
