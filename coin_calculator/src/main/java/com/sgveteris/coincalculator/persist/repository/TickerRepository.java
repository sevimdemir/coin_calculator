package com.sgveteris.coincalculator.persist.repository;

import com.sgveteris.coincalculator.persist.entity.TickerStatus;
import com.sgveteris.coincalculator.persist.entity.TickersEntity;
import com.sgveteris.coincalculator.persist.dao.ITickerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class TickerRepository implements ITickerRepository{

    @Autowired
    private ITickerDao tickerDao;

    @Override
    public Boolean isTickerValid(String coinType, String currency){
        Optional<TickersEntity> tickerSymbol = tickerDao.findByCoinTypeAndCurrencyAndStatus(coinType, currency, TickerStatus.ACTIVE);
        return tickerSymbol.isPresent();
    }
}
