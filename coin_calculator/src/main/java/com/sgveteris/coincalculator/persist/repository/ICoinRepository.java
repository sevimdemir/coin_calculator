package com.sgveteris.coincalculator.persist.repository;

import com.sgveteris.coincalculator.dto.CoinDto;
import com.sgveteris.coincalculator.persist.entity.CoinEntity;

import java.util.List;
import java.util.Optional;

public interface ICoinRepository {

    Optional<CoinEntity> findByCoinType(String coinType);
    List<CoinDto> findAll() ;
}
