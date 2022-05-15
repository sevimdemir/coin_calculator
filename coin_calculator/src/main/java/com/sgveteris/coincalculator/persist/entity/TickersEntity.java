package com.sgveteris.coincalculator.persist.entity;

import lombok.*;

import javax.persistence.*;

@Entity(name = "tickers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TickersEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "coin_type", nullable = false)
    private String coinType;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TickerStatus status;

}
