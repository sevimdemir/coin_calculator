package com.sgveteris.coincalculator.persist.repository.impl;

import com.sgveteris.coincalculator.dto.CoinDto;
import com.sgveteris.coincalculator.persist.dao.ICoinDao;
import com.sgveteris.coincalculator.persist.entity.CoinEntity;
import com.sgveteris.coincalculator.persist.repository.ICoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class CoinRepository implements ICoinRepository {


    @Autowired
    private ICoinDao coinDao;

    @Override
    public List<CoinDto> findAll() {
        List<CoinDto> coinDtoList = coinDao.findAll().stream()
                .map(ent -> new CoinDto(ent.getId(), ent.getCoinType()))
                .collect(Collectors.toList());
        return coinDtoList;
    }

    @Override
    public Optional<CoinEntity> findByCoinType(String coinType) {
        return Optional.empty();
    }
}
