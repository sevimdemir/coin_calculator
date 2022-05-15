package com.sgveteris.coincalculator.controller;

import com.sgveteris.coincalculator.controller.form.PriceForm;
import com.sgveteris.coincalculator.dto.CalculationResult;
import com.sgveteris.coincalculator.exception.TickerInvalidException;
import com.sgveteris.coincalculator.exception.TickerNotFoundException;
import com.sgveteris.coincalculator.service.IPriceService;
import com.sgveteris.coincalculator.util.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/price")
@Api(value = "price api for coin calculation")
@Validated
public class PriceController {

    @Autowired
    private IPriceService priceService;

    @GetMapping("/calculate")
    @ApiOperation(value = "coin calculator operation")
    public ResponseEntity<JsonResponse> getPrice(@Valid PriceForm priceForm) throws TickerNotFoundException, TickerInvalidException {
        CalculationResult calculationResult = priceService.getPrice(priceForm.getCurrency().toUpperCase(),
                priceForm.getAmount(),
                priceForm.getCoinType().toUpperCase());
        return new ResponseEntity<JsonResponse>(JsonResponse.success(calculationResult), HttpStatus.OK);
    }

    @ExceptionHandler({TickerNotFoundException.class, TickerInvalidException.class})
    public ResponseEntity<JsonResponse>  handleException(Exception exception){
        System.out.println("handle " + exception.getMessage());
        return new ResponseEntity<JsonResponse>(JsonResponse.failure(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

}
