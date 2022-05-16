package com.sgveteris.coincalculator.service;

import com.sgveteris.coincalculator.dto.CoinDto;
import com.sgveteris.coincalculator.dto.CurrencyDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICoinService {

    List<CoinDto> getCoins();

}
