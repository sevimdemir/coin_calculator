package com.sgveteris.coincalculator.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity(name = "coins")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CoinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "coin_type", nullable = false)
    private String coinType;

    @OneToMany(mappedBy = "coin")
    private List<CoinCurrencyRelationEntity> relations;
}
