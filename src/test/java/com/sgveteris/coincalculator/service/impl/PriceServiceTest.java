package com.sgveteris.coincalculator.service.impl;

import com.sgveteris.coincalculator.dto.CalculationResult;
import com.sgveteris.coincalculator.dto.TickersDto;
import com.sgveteris.coincalculator.exception.TickerInvalidException;
import com.sgveteris.coincalculator.exception.TickerNotFoundException;
import com.sgveteris.coincalculator.persist.repository.ICoinCurrencyRelationsRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceTest {

    PriceService priceService;

    @Mock
    ICoinCurrencyRelationsRepository coinCurrencyRelationsRepositoryMock;

    @Mock
    Environment environment;

    @Mock
    RestTemplate restTemplateMock;

    @BeforeEach
    public void setUp() throws Exception {
        priceService = new PriceService(environment, coinCurrencyRelationsRepositoryMock,  restTemplateMock);
    }

    @Test
    void whenInputsAreCorrect_ShouldReturnCorrectResult() {
        TickersDto tickerDto = new TickersDto( "BTC-USD", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
        when(coinCurrencyRelationsRepositoryMock.isTickerValid(Mockito.anyString(),Mockito.anyString())).thenReturn(Boolean.TRUE);
        when(restTemplateMock.getForObject(Mockito.any(URI.class), Mockito.any(Class.class))).thenReturn(tickerDto);
        when(environment.getProperty(Mockito.anyString())).thenReturn("http://127.0.0.1/api/{symbol}");
        //
        try {
            CalculationResult priceResponse = priceService.getPrice("USD", new BigDecimal(100), "BTC");
            assertNotNull(priceResponse);
            assertEquals("BTC", priceResponse.getCoinType());
        } catch (TickerNotFoundException e) {
            fail("unexpected TickerNotFoundException");
        } catch (TickerInvalidException e) {
            fail("unexpected TickerInvalidException");
        }
    }

    @Test
    void whenSymbolIsInvalid_ShouldThrowException() {
        TickersDto tickerDto = new TickersDto( "BTC-USD", BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE);
        when(coinCurrencyRelationsRepositoryMock.isTickerValid(Mockito.anyString(),Mockito.anyString())).thenReturn(Boolean.FALSE);
        //
        try {
            CalculationResult priceResponse = priceService.getPrice("USD", new BigDecimal(100), "BTC");
            fail("unexpected method return");
        } catch (TickerNotFoundException e) {
            fail("unexpected TickerNotFoundException");
        } catch (TickerInvalidException e) {
            assertTrue(Boolean.TRUE);
        }
    }
}