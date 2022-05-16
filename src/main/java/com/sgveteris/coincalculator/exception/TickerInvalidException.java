package com.sgveteris.coincalculator.exception;

public class TickerInvalidException extends Exception {

    public TickerInvalidException(String symbol) {
        super(symbol.concat(" is invalid"));
    }

}
