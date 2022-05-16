package com.sgveteris.coincalculator.service.impl;

import com.sgveteris.coincalculator.dto.CoinDto;
import com.sgveteris.coincalculator.persist.repository.ICoinRepository;
import com.sgveteris.coincalculator.service.ICoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoinService implements ICoinService {

    private final ICoinRepository coinRepository;

    @Override
    public List<CoinDto> getCoins() {
        return coinRepository.findAll();
    }
}
