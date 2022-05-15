package com.sgveteris.coincalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class CoinCalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoinCalculatorApplication.class, args);
	}

}
