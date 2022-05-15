package com.sgveteris.coincalculator.service;

import com.sgveteris.coincalculator.dto.CalculationResult;
import com.sgveteris.coincalculator.exception.TickerInvalidException;
import com.sgveteris.coincalculator.exception.TickerNotFoundException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface IPriceService {
    CalculationResult getPrice(String currency, BigDecimal amount, String coinType) throws TickerNotFoundException, TickerInvalidException;
}
