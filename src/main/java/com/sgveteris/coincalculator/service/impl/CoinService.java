package com.sgveteris.coincalculator.service.impl;

import com.sgveteris.coincalculator.dto.CoinDto;
import com.sgveteris.coincalculator.persist.repository.ICoinRepository;
import com.sgveteris.coincalculator.service.ICoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoinService implements ICoinService {

    @Autowired
    private ICoinRepository coinRepository;

    @Override
    public List<CoinDto> getCoins() {
        return coinRepository.findAll();
    }
}
