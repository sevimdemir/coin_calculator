package com.sgveteris.coincalculator.persist.repository.impl;

import com.sgveteris.coincalculator.persist.dao.ICoinCurrencyRelationsDao;
import com.sgveteris.coincalculator.persist.dao.ICoinDao;
import com.sgveteris.coincalculator.persist.dao.ICurrencyDao;
import com.sgveteris.coincalculator.persist.entity.CoinCurrencyRelationEntity;
import com.sgveteris.coincalculator.persist.entity.CoinEntity;
import com.sgveteris.coincalculator.persist.entity.CurrencyEntity;
import com.sgveteris.coincalculator.persist.repository.ICoinCurrencyRelationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CoinCurrencyRelationsRepository implements ICoinCurrencyRelationsRepository {

    @Autowired
    private ICoinCurrencyRelationsDao coinCurrencyRelationsDao;

    @Autowired
    private ICurrencyDao currencyDao;
    @Autowired
    private ICoinDao coinDao;

    @Override
    public Boolean isTickerValid(String currency, String coinType) {
        Optional<CurrencyEntity> byCurrency = currencyDao.findByCurrency(currency);
        Optional<CoinEntity> byCoinType = coinDao.findByCoinType(coinType);
        if (byCurrency.isEmpty() || byCoinType.isEmpty()) {
            return Boolean.FALSE;
        }
        Optional<CoinCurrencyRelationEntity> byCoinIdAndCurrencyId = coinCurrencyRelationsDao.findByCoinIdAndCurrencyId(byCoinType.get().getId(), byCurrency.get().getId());
        return byCoinIdAndCurrencyId.isPresent();
    }
}
