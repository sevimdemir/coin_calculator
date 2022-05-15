package com.sgveteris.coincalculator.service.impl;

import com.sgveteris.coincalculator.dto.CalculationResult;
import com.sgveteris.coincalculator.dto.TickersDto;
import com.sgveteris.coincalculator.exception.TickerInvalidException;
import com.sgveteris.coincalculator.exception.TickerNotFoundException;
import com.sgveteris.coincalculator.persist.repository.ICoinCurrencyRelationsRepository;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.net.URI;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestPropertySource("application.properties")
class PriceServiceTest {

    @InjectMocks
    PriceService priceService;

    @Mock
    ICoinCurrencyRelationsRepository coinCurrencyRelationsRepositoryMock;

    @Mock
    RestTemplate restTemplateMock;

    @Before
    void setUp() {
        //ReflectionTestUtils.setField(priceService, "uri", "https://localhost:8080/{symbol}");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getPrice() {
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
}