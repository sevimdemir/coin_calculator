package com.sgveteris.coincalculator.persist.repository.impl;

import com.sgveteris.coincalculator.dto.CurrencyDto;
import com.sgveteris.coincalculator.persist.dao.ICurrencyDao;
import com.sgveteris.coincalculator.persist.repository.ICurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CurrencyRepository implements ICurrencyRepository {

    @Autowired
    private ICurrencyDao currencyDao;

    @Override
    public List<CurrencyDto> findAll() {
        List<CurrencyDto> currencyDto = currencyDao.findAll().stream()
                .map(ent -> new CurrencyDto(ent.getId(), ent.getCurrency()))
                .collect(Collectors.toList());
        return currencyDto;
    }
}
