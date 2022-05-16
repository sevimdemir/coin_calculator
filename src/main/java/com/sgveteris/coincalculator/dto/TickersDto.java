package com.sgveteris.coincalculator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TickersDto implements Serializable {
    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("price_24h")
    private BigDecimal price24;

    @JsonProperty("volume_24h")
    private BigDecimal volume24;

    @JsonProperty("last_trade_price")
    private BigDecimal lastTradePrice;
}
