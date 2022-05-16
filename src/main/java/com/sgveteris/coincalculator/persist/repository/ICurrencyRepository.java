package com.sgveteris.coincalculator.persist.repository;

import com.sgveteris.coincalculator.dto.CurrencyDto;
import com.sgveteris.coincalculator.persist.entity.CoinEntity;
import com.sgveteris.coincalculator.persist.entity.CurrencyEntity;

import java.util.List;
import java.util.Optional;

public interface ICurrencyRepository {

    List<CurrencyDto> findAll();
}
