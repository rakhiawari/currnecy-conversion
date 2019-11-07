package com.convertor.currencyconvertor.repository;


import com.convertor.currencyconvertor.models.CurrencyApi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyApiRepository extends CrudRepository<CurrencyApi, String> {

    CurrencyApi findByCurrencyCode(String to);
}
