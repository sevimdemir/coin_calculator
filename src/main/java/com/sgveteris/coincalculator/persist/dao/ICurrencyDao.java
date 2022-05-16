package com.sgveteris.coincalculator.persist.dao;


import com.sgveteris.coincalculator.persist.entity.CoinEntity;
import com.sgveteris.coincalculator.persist.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICurrencyDao extends JpaRepository<CurrencyEntity, Long> {

    Optional<CurrencyEntity> findByCurrency(String currency);
}
