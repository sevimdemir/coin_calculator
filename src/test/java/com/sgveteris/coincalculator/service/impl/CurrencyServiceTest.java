package com.sgveteris.coincalculator.service.impl;

import com.sgveteris.coincalculator.dto.CurrencyDto;
import com.sgveteris.coincalculator.persist.repository.ICurrencyRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrencyServiceTest {

    @InjectMocks
    CurrencyService currencyService;

    @Mock
    ICurrencyRepository currencyRepositoryMock;

    @Before
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    void tearDown() {
    }

    @Test
    public void getCurrencies() {
        List<CurrencyDto> currencyList = new ArrayList<CurrencyDto>();
        currencyList.add(new CurrencyDto(1L, "USD"));
        when(currencyRepositoryMock.findAll()).thenReturn(currencyList);
        //
        List<CurrencyDto> returnCurrencies = currencyService.getCurrencies();
        //
        assertEquals(currencyList.size(), returnCurrencies.size());
        assertEquals(currencyList.get(0), returnCurrencies.get(0));
    }
}