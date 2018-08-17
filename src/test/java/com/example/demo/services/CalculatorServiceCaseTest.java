package com.example.demo.services;


import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class CalculatorServiceCaseTest extends TestCase{
	
	Double number1 = 10d;
	Double number2 = 20d;
	String operationSum = "+";
	String operationSub = "-";
	String operationProd = "*";
	String operationDiv = "/";
	
	CalculatorService calculatorService = new CalculatorService();
        
        @BeforeEach
        public void showTestName(TestInfo testInfo){
        System.out.println("Beggining test: " + testInfo.getDisplayName()  );
        }
       
	@Test
        @DisplayName("Test Sum")
	public void testSum() {
		
		Double sumResult = calculatorService.getResult(number1, number2, operationSum);
		assertEquals(30d,sumResult);
	}
	
        @Test
        @DisplayName("Test Substraction")
	public void testSub() {
		
		Double subResult = calculatorService.getResult(number1, number2, operationSub);
		assertEquals(-10d,subResult);
	}
	
        @Test
        @DisplayName("Test Product")
	public void testProd() {
		
		Double prodResult = calculatorService.getResult(number1, number2, operationProd);
		assertEquals(200d,prodResult);
	}
	
        @Test
        @DisplayName("Test Division")
	public void testDiv() {
		
		Double divResult = calculatorService.getResult(number1, number2, operationDiv);
		assertEquals(0.5d,divResult);
	}	
        
        @Test
        @DisplayName("Test Division by zero")
        public void testDivByZero(){
           
            assertThrows(ArithmeticException.class,
                    ()->{
                        calculatorService.getResult(number1, 0D, operationDiv);
                    });
        }
}