package com.sgveteris.coincalculator.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class CurrencyDto implements Serializable {

    private Long id;

    private String currency;
}
