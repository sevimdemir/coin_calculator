package com.sgveteris.coincalculator.exception;

public class TickerNotFoundException extends Exception{

    public TickerNotFoundException(String symbol){
        super("Cannot find the response for ".concat(symbol));
    }

}
