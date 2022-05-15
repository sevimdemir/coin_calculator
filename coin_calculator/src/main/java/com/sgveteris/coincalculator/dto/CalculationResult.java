package com.sgveteris.coincalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CalculationResult implements Serializable {

    private static final long serialVersionUID = 7156526077883281623L;

    private BigDecimal coinsToReceive;

    private String coinType;

    private Date date;

    private String fiatCurrency;

    private BigDecimal fiatAmount;

}
