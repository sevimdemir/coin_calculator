package com.sgveteris.coincalculator.controller.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceForm {
    @NotNull
    @Size(min=3, max=3)
    private String currency;

    @NotNull
    @Min(25)
    @Max(5000)
    private BigDecimal amount;

    @NotNull
    private String coinType;
}
