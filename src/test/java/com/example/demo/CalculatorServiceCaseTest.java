package com.example.demo;

import com.example.demo.services.CalculatorService;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class CalculatorServiceCaseTest extends TestCase{
		
	CalculatorService calculatorService = new CalculatorService();
        
        @BeforeEach
        public void showTestName(TestInfo testInfo){
        System.out.println("Beggining test: " + testInfo.getDisplayName()  );
        }
       
	@Test
        @DisplayName("Test Sum")
	public void testSum() {
		
            Queue<String> mock = new LinkedList<String>();
            mock.addAll(Arrays.asList("10","+","20","+","30"));
            
            Double sumResult = calculatorService.operate(mock);
            assertEquals(60d,sumResult);
	}
	
        @Test
        @DisplayName("Test Substraction")
	public void testSub() {
		
            Queue<String> mock = new LinkedList<String>();
            mock.addAll(Arrays.asList("10","-","20","-","30"));
            
            Double subResult = calculatorService.operate(mock);
            assertEquals(-40d,subResult);
	}
	
        @Test
        @DisplayName("Test Product")
	public void testProd() {
	
            Queue<String> mock = new LinkedList<String>();
            mock.addAll(Arrays.asList("1","*","10","*","10"));
            
            Double prodResult = calculatorService.operate(mock);
            assertEquals(100d,prodResult);
	}
	
        @Test
        @DisplayName("Test Division")
	public void testDiv() {
		
            Queue<String> mock = new LinkedList<String>();
            mock.addAll(Arrays.asList("20","/","2","/","10"));
            
            Double divResult = calculatorService.operate(mock);
            assertEquals(1d,divResult);
	}	
        
        @Test
        @DisplayName("Test Division by zero")
        public void testDivByZero(){
            
            Queue<String> mock = new LinkedList<String>();
            mock.addAll(Arrays.asList("5","/","0"));
           
            assertThrows(ArithmeticException.class,
                    ()->{
                        calculatorService.operate(mock);
                    });
        }
}
