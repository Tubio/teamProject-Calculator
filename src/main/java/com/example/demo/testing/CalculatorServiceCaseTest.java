package com.example.demo.testing;

import com.example.demo.services.CalculatorService;

import junit.framework.TestCase;

public class CalculatorServiceCaseTest extends TestCase {
	
	Double number1 = 10d;
	Double number2 = 20d;
	String operationSum = "+";
	String operationSub = "-";
	String operationProd = "*";
	String operationDiv = "/";
	
	CalculatorService calculatorService = new CalculatorService();
	
	public void testSum() {
		
		Double sumResult = calculatorService.getResult(number1, number2, operationSum);
		assertEquals(30d,sumResult);
	}
	
	public void testSub() {
		
		Double subResult = calculatorService.getResult(number1, number2, operationSub);
		assertEquals(-10d,subResult);
	}
	
	public void testProd() {
		
		Double prodResult = calculatorService.getResult(number1, number2, operationProd);
		assertEquals(200d,prodResult);
	}
	
	public void testDiv() {
		
		Double divResult = calculatorService.getResult(number1, number2, operationDiv);
		assertEquals(0.5d,divResult);
	}	
}
