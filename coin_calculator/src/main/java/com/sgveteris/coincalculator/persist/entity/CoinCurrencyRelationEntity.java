package com.sgveteris.coincalculator.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "coin_currency_relations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoinCurrencyRelationEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "coin_id")
    private CoinEntity coin;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private CurrencyEntity currency;
}
