package com.sgveteris.coincalculator.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CoinDto implements Serializable {
    
    private Long id;

    private String coinType;
}
