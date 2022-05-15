package com.sgveteris.coincalculator.service.impl;

import com.sgveteris.coincalculator.dto.CalculationResult;
import com.sgveteris.coincalculator.dto.TickersDto;
import com.sgveteris.coincalculator.exception.TickerInvalidException;
import com.sgveteris.coincalculator.exception.TickerNotFoundException;
import com.sgveteris.coincalculator.persist.repository.ICoinCurrencyRelationsRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class PriceServiceTest {

    @Autowired
    PriceService priceService;

    @MockBean
    ICoinCurrencyRelationsRepository coinCurrencyRelationsRepositoryMock;

    @MockBean
    RestTemplate restTemplateMock;

    @Test
    void whenInputsAreCorrect_ShouldReturnCorrectResult() {
        TickersDto tickerDto = new TickersDto( "BTC-USD", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
        when(coinCurrencyRelationsRepositoryMock.isTickerValid(Mockito.anyString(),Mockito.anyString())).thenReturn(Boolean.TRUE);
        when(restTemplateMock.getForObject(Mockito.any(URI.class), Mockito.any(Class.class))).thenReturn(tickerDto);
        //
        try {
            CalculationResult priceResponse = priceService.getPrice("USD", new BigDecimal(100), "BTC");
            assertNotNull(priceResponse);
            assertEquals("BTC", priceResponse.getCoinType());
        } catch (TickerNotFoundException e) {
            assertFalse(Boolean.TRUE);
        } catch (TickerInvalidException e) {
            assertFalse(Boolean.TRUE);
        }
    }

    @Test
    void whenSymbolIsInvalid_ShouldThrowException() {
        TickersDto tickerDto = new TickersDto( "BTC-USD", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
        when(coinCurrencyRelationsRepositoryMock.isTickerValid(Mockito.anyString(),Mockito.anyString())).thenReturn(Boolean.FALSE);
        when(restTemplateMock.getForObject(Mockito.any(URI.class), Mockito.any(Class.class))).thenReturn(tickerDto);
        //
        try {
            CalculationResult priceResponse = priceService.getPrice("USD", new BigDecimal(100), "BTC");
            assertFalse(Boolean.TRUE);
        } catch (TickerNotFoundException e) {
            assertFalse(Boolean.TRUE);
        } catch (TickerInvalidException e) {
            assertTrue(Boolean.TRUE);
        }
    }
}