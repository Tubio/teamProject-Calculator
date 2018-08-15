package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	public Double getResult(Double number1, Double number2, String operation) {
		
		Double result;
		
		if		(operation.equals("+"))
			result = number1 + number2;
		
		else if (operation.equals("-"))
			result = number1 - number2;
		
		else if (operation.equals("*"))
			result = number1 * number2;
		
		else if (operation.equals("/"))
			result = number1 / number2;
		
		else result = null; //invalid operation
		
		return result;
	}
}
