package com.sgveteris.coincalculator.persist.repository;

import com.sgveteris.coincalculator.dto.CurrencyDto;

import java.util.List;

public interface ICoinCurrencyRelationsRepository {

    Boolean isTickerValid(String currency, String coinType);
}
