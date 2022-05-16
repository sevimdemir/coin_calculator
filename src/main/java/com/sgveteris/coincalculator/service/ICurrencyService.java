package com.sgveteris.coincalculator.service;

import com.sgveteris.coincalculator.dto.CurrencyDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICurrencyService {

    List<CurrencyDto> getCurrencies();

}
