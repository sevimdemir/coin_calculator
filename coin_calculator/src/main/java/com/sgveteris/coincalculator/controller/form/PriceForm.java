package com.sgveteris.coincalculator.controller.form;

import io.swagger.annotations.ApiModelProperty;
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
    @ApiModelProperty(notes = "currency of fiat length should be 3", example = "USD", required = true, position = 0)
    private String currency;

    @NotNull
    @Min(25)
    @Max(5000)
    @ApiModelProperty(notes = "amount should be between 25 and 5000", example = "100", required = true, position = 1)
    private BigDecimal amount;

    @NotNull
    @ApiModelProperty(notes = "coin type", example = "BTC", required = true, position = 2)
    private String coinType;
}
