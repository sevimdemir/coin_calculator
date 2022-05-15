package com.sgveteris.coincalculator.persist.repository;

public interface ITickerRepository {

    Boolean isTickerValid(String coinType, String currency);
}
