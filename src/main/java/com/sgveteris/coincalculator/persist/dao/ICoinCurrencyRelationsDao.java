package com.sgveteris.coincalculator.persist.dao;


import com.sgveteris.coincalculator.persist.entity.CoinCurrencyRelationEntity;
import com.sgveteris.coincalculator.persist.entity.CoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICoinCurrencyRelationsDao extends JpaRepository<CoinCurrencyRelationEntity, Long> {
    Optional<CoinCurrencyRelationEntity> findByCoinIdAndCurrencyId(Long coinId, Long currencyId);
}
