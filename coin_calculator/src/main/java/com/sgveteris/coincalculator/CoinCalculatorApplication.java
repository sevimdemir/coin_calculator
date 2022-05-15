package com.sgveteris.coincalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CoinCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinCalculatorApplication.class, args);
	}

}
