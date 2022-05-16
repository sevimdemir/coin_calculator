package com.sgveteris.coincalculator.service.impl;

import com.sgveteris.coincalculator.dto.CalculationResult;
import com.sgveteris.coincalculator.dto.TickersDto;
import com.sgveteris.coincalculator.dto.builder.CalculationResultBuilder;
import com.sgveteris.coincalculator.exception.TickerInvalidException;
import com.sgveteris.coincalculator.exception.TickerNotFoundException;
import com.sgveteris.coincalculator.persist.repository.ICoinCurrencyRelationsRepository;
import com.sgveteris.coincalculator.service.IPriceService;
import com.sgveteris.coincalculator.util.KeyBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;

@Service
@RequiredArgsConstructor
public class PriceService implements IPriceService {

    private final Environment env;

    private final ICoinCurrencyRelationsRepository coinCurrencyRelationsRepository;

    private final RestTemplate restTemplate;

    @Override
    @Cacheable(value = "priceCache")
    public CalculationResult getPrice(String currency, BigDecimal amount, String coinType) throws TickerNotFoundException, TickerInvalidException {
        final String symbol = KeyBuilder.convert(coinType, currency);
        if (!coinCurrencyRelationsRepository.isTickerValid(currency, coinType)) {
            throw new TickerInvalidException(symbol);
        }
        URI url = new UriTemplate(env.getProperty("api.blockchain.uri")).expand(symbol);
        TickersDto result = restTemplate.getForObject(url, TickersDto.class);
        if (result == null) {
            throw new TickerNotFoundException(symbol);
        }
        return new CalculationResultBuilder()
                .fiatCurrency(currency)
                .coinsToReceive(amount.divide(result.getLastTradePrice(), 8, RoundingMode.UP))
                .fiatAmount(result.getLastTradePrice())
                .coinType(coinType)
                .build();
    }
}
