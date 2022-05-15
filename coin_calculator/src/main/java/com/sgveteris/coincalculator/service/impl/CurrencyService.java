package com.sgveteris.coincalculator.service.impl;

import com.sgveteris.coincalculator.dto.CurrencyDto;
import com.sgveteris.coincalculator.persist.repository.ICurrencyRepository;
import com.sgveteris.coincalculator.service.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyService implements ICurrencyService {

    @Autowired
    private ICurrencyRepository currencyRepository;

    @Override
    public List<CurrencyDto> getCurrencies(){
       return currencyRepository.findAll();
    }
}
