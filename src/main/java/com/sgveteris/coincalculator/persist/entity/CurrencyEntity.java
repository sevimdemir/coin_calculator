package com.sgveteris.coincalculator.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "currencies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "currency", nullable = false)
    private String currency;

    @OneToMany(mappedBy = "currency")
    private List<CoinCurrencyRelationEntity> relations;
}
