package com.sgveteris.coincalculator.service;

import com.sgveteris.coincalculator.dto.CalculationResult;
import com.sgveteris.coincalculator.dto.TickersDto;
import com.sgveteris.coincalculator.exception.TickerInvalidException;
import com.sgveteris.coincalculator.exception.TickerNotFoundException;
import com.sgveteris.coincalculator.persist.repository.ITickerRepository;
import com.sgveteris.coincalculator.util.KeyBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;

@Service
public class PriceService implements IPriceService {

    @Value("${api.blockchain.uri}")
    private String uri = "";

    @Autowired
    private ITickerRepository tickerRepository;

    @Override
    public CalculationResult getPrice(String currency, BigDecimal amount, String coinType) throws TickerNotFoundException, TickerInvalidException {
        final String symbol = KeyBuilder.convert(coinType, currency);
        if(!tickerRepository.isTickerValid(coinType,currency)){
            throw new TickerInvalidException(symbol);
        }
        URI url = new UriTemplate(uri).expand(symbol);
        TickersDto result = new RestTemplate().getForObject(url, TickersDto.class);
        if (result == null) {
            throw new TickerNotFoundException(symbol);
        }
        return new CalculationResult(amount.divide(result.getLastTradePrice(), 8, RoundingMode.UP));
    }
}
