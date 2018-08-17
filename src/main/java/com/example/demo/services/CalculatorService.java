package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service("calculatorService")
public class CalculatorService {
	
	public Double getResult(Double number1, Double number2, String operation) {
		
		Double result = 0D;
		
		if		(operation.equals("+"))
			result = number1 + number2;
		
		else if (operation.equals("-"))
			result = number1 - number2;
		
		else if (operation.equals("*"))
			result = number1 * number2;
		
		else if (operation.equals("/")){
                        if(number2 == 0){
                          System.out.println("Can't divide by zero");  
                          throw new ArithmeticException("Can't divide by zero");}
                        
			result = number1 / number2;

                        }
		
		else result = null; //invalid operation
		
		return result;
	}
}
