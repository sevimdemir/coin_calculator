package com.sgveteris.coincalculator.persist.dao;


import com.sgveteris.coincalculator.persist.entity.CoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICoinDao extends JpaRepository<CoinEntity, Long> {
    Optional<CoinEntity> findByCoinType(String coinType);
}
