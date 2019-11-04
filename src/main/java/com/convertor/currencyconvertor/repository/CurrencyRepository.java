package com.convertor.currencyconvertor.repository;

import com.convertor.currencyconvertor.models.Api;
import com.convertor.currencyconvertor.models.CurrencyConvertor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Api, String> {

}
