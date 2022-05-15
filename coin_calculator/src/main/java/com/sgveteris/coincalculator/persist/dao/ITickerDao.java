package com.sgveteris.coincalculator.persist.dao;


import com.sgveteris.coincalculator.persist.entity.TickerStatus;
import com.sgveteris.coincalculator.persist.entity.TickersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITickerDao extends JpaRepository<TickersEntity, Long> {

    Optional<TickersEntity> findByCoinTypeAndCurrencyAndStatus(String coinType, String currency, TickerStatus status);
}
