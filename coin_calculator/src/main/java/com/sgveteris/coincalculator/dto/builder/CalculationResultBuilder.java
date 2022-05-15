package com.sgveteris.coincalculator.dto.builder;

import com.sgveteris.coincalculator.dto.CalculationResult;

import java.math.BigDecimal;
import java.util.Calendar;

public class CalculationResultBuilder {

    private CalculationResult result;

    public CalculationResultBuilder() {
        result = new CalculationResult();
        result.setDate(Calendar.getInstance().getTime());
    }

    public CalculationResultBuilder fiatAmount(BigDecimal fiatAmount) {
        result.setFiatAmount(fiatAmount);
        return this;
    }

    public CalculationResultBuilder fiatCurrency(String fiatCurrency) {
        result.setFiatCurrency(fiatCurrency);
        return this;
    }

    public CalculationResultBuilder coinType(String coinType) {
        result.setCoinType(coinType);
        return this;
    }

    public CalculationResultBuilder coinsToReceive(BigDecimal coinsToReceive) {
        result.setCoinsToReceive(coinsToReceive);
        return this;
    }

    public CalculationResult build() {
        return result;
    }

}
