package com.sgveteris.coincalculator.controller;

import com.sgveteris.coincalculator.service.ICoinService;
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
@RequestMapping("/api/v1/coin")
@Api(value = "coin controller")
public class CoinController {

    @Autowired
    private ICoinService coinService;

    @GetMapping("/all")
    @ApiOperation(value = "all usable coin types")
    public ResponseEntity<JsonResponse> getCoins(){
        return new ResponseEntity<JsonResponse>(JsonResponse.success(coinService.getCoins()), HttpStatus.OK);
    }
}
