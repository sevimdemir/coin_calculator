package com.sgveteris.coincalculator.service.impl;

import com.sgveteris.coincalculator.dto.CurrencyDto;
import com.sgveteris.coincalculator.persist.repository.ICurrencyRepository;
import com.sgveteris.coincalculator.service.ICurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService implements ICurrencyService {

    private final ICurrencyRepository currencyRepository;

    @Override
    public List<CurrencyDto> getCurrencies(){
       return currencyRepository.findAll();
    }
}
