package com.sgveteris.coincalculator.service.impl;

import com.sgveteris.coincalculator.dto.CoinDto;
import com.sgveteris.coincalculator.persist.repository.ICoinRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CoinServiceTest {

    @InjectMocks
    CoinService coinService;

    @Mock
    ICoinRepository coinRepositoryMock;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getCoins() {

        List<CoinDto> coinList = new ArrayList<>();
        coinList.add(new CoinDto(1L, "BTC"));
        when(coinRepositoryMock.findAll()).thenReturn(coinList);
        //
        List<CoinDto> returnCoinList = coinService.getCoins();
        //
        assertEquals(coinList.size(), returnCoinList.size());
        assertEquals(coinList.get(0), returnCoinList.get(0));
    }
}