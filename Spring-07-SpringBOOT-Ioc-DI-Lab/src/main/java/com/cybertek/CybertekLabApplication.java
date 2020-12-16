package com.cybertek;

import com.cybertek.calculator.Calculator;
import com.cybertek.enums.City;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CybertekLabApplication {

	public static void main(String[] args) throws Exception {

		ApplicationContext container = SpringApplication.run(CybertekLabApplication.class, args);
		Calculator calculator = container.getBean("calculator",Calculator.class);
		System.out.println(calculator.getTotalCarpetCost(City.SAN_aNTONIO));  //Total Cost for Carpet :55.00
	}

}
