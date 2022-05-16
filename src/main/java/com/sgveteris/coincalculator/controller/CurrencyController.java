package com.sgveteris.coincalculator.controller;

import com.sgveteris.coincalculator.service.ICurrencyService;
import com.sgveteris.coincalculator.util.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/currency")
@Api(value = "currency controller")
public class CurrencyController {

    @Autowired
    private ICurrencyService currencyService;

    @GetMapping("/all")
    @ApiOperation(value = "all usable currency types")
    public ResponseEntity<JsonResponse> getCurrencies(){
        return new ResponseEntity<JsonResponse>(JsonResponse.success(currencyService.getCurrencies()), HttpStatus.OK);
    }
}
