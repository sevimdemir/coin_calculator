package com.sgveteris.coincalculator.persist.repository.impl;

import com.sgveteris.coincalculator.dto.CurrencyDto;
import com.sgveteris.coincalculator.persist.dao.ICurrencyDao;
import com.sgveteris.coincalculator.persist.repository.ICurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CurrencyRepository implements ICurrencyRepository {

    private final ICurrencyDao currencyDao;

    @Override
    public List<CurrencyDto> findAll() {
        return currencyDao.findAll().stream()
                .map(ent -> new CurrencyDto(ent.getId(), ent.getCurrency()))
                .collect(Collectors.toList());
    }
}
