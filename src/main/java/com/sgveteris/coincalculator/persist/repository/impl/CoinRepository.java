package com.sgveteris.coincalculator.persist.repository.impl;

import com.sgveteris.coincalculator.dto.CoinDto;
import com.sgveteris.coincalculator.persist.dao.ICoinDao;
import com.sgveteris.coincalculator.persist.entity.CoinEntity;
import com.sgveteris.coincalculator.persist.repository.ICoinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CoinRepository implements ICoinRepository {
    private final ICoinDao coinDao;

    @Override
    public List<CoinDto> findAll() {
        return coinDao.findAll().stream()
                .map(ent -> new CoinDto(ent.getId(), ent.getCoinType()))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<CoinEntity> findByCoinType(String coinType) {
        return Optional.empty();
    }
}
