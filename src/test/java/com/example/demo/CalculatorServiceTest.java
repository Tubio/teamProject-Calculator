package com.example.demo;

import com.example.demo.services.CalculatorService;
import static java.lang.Double.max;
import static java.lang.Double.min;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

import junit.framework.TestCase;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorServiceTest extends TestCase{
		
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
        
        Double sumResult = calculatorService.operate(mock).get();
        assertEquals(60d,sumResult);
    }
        
    @Test
    @DisplayName("Test Substraction")
    public void testSub() {
		
        Queue<String> mock = new LinkedList<String>();
        mock.addAll(Arrays.asList("10","-","20","-","30"));
        
        Double subResult = calculatorService.operate(mock).get();
        assertEquals(-40d,subResult);
    }
	
    @Test
    @DisplayName("Test Product")
    public void testProd() {
	
        Queue<String> mock = new LinkedList<String>();
        mock.addAll(Arrays.asList("1","*","10","*","10"));
        
        Double prodResult = calculatorService.operate(mock).get();
        assertEquals(100d,prodResult);
	}
	
    @Test
    @DisplayName("Test Division")
    public void testDiv() {
		
        Queue<String> mock = new LinkedList<String>();
        mock.addAll(Arrays.asList("20","/","2","/","10"));
        
        Double divResult = calculatorService.operate(mock).get();
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
    
    @Test
    @DisplayName("Test Valid Queue")
    public void testValidQueue() {
        
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList("1","+","2","-","1"));
        
        assertTrue(calculatorService.operate(queue).isPresent());
    }
    
    @Test
    @DisplayName("Test Invalid Queue (wrong size)")
    public void testInvalidSizeQueue() {
       
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList("1","+"));
        
        assertThrows(IllegalArgumentException.class, () ->
            {
                calculatorService.operate(queue);
            });
    }
    
    @Test
    @DisplayName("Test Invalid Queue (wrong data)")
    public void testInvalidDataQueue() {
        
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList("+","+"));
        
        assertThrows(IllegalArgumentException.class, () ->
            {
                calculatorService.operate(queue);
            });       
    }
    
    @Test
    @DisplayName("Test Empty Queue")
    public void testEmptyQueue() {
        
        Queue<String> emptyQueue = new LinkedList<>();
        
        assertThrows(IllegalArgumentException.class, () ->
            {
                calculatorService.operate(emptyQueue);
            });
    }
    
    @RepeatedTest(25)
    @DisplayName("Test Sum Returning Double")
    public void testRepeatedSum() {
        
        Queue<String> sum = new LinkedList<>();
        Double min = -1000.000d;
        Double max = 1000.000d;
        Double num1 = ThreadLocalRandom.current().nextDouble(min,max);
        Double num2 = ThreadLocalRandom.current().nextDouble(min,max);
        
        sum.addAll(Arrays.asList(Double.toString(num1),"+",Double.toString(num2)));
        Double sumResult = calculatorService.operate(sum).get();
        
        assertTrue(sumResult >= -2000d && sumResult <= 2000d);        
    }
    
    @RepeatedTest(25)
    @DisplayName("Test Sub Returning Double")
    public void testRepeatedSub() {
        
        Queue<String> sub = new LinkedList<>();
        Double min = -1000.000d;
        Double max = 1000.000d;
        Double num1 = ThreadLocalRandom.current().nextDouble(min,max);
        Double num2 = ThreadLocalRandom.current().nextDouble(min,max);
        
        sub.addAll(Arrays.asList(Double.toString(num1),"-",Double.toString(num2)));
        Double sumResult = calculatorService.operate(sub).get();
        
        assertTrue(sumResult >= -2000d && sumResult <= 2000d);        
    }
    
    @RepeatedTest(25)
    @DisplayName("Test Prod Returning Double")
    public void testRepeatedProd() {
        
        Queue<String> prod = new LinkedList<>();
        Double min = -1000.000d;
        Double max = 1000.000d;
        Double num1 = ThreadLocalRandom.current().nextDouble(min,max);
        Double num2 = ThreadLocalRandom.current().nextDouble(min,max);
        
        prod.addAll(Arrays.asList(Double.toString(num1),"*",Double.toString(num2)));
        Double sumResult = calculatorService.operate(prod).get();
        
        assertTrue(sumResult >= -1000000d && sumResult <= 1000000d);        
    }
    
    @RepeatedTest(25)
    @DisplayName("Test Div Returning Double")
    public void testRepeatedDiv() {
        
        Queue<String> div = new LinkedList<>();
        Double min = -1000.000d;
        Double max = 1000.000d;
        Double num1 = ThreadLocalRandom.current().nextDouble(min,max);
        Double num2;
        
        do{
            num2 = ThreadLocalRandom.current().nextDouble(min,max);
        }while(num2 == 0d);
        
        div.addAll(Arrays.asList(Double.toString(num1),"/",Double.toString(num2)));
        Double sumResult = calculatorService.operate(div).get();
        
        assertTrue(sumResult >= -1000000d && sumResult <= 1000000d);        
    }
}