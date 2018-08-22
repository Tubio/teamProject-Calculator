package com.example.demo;

import com.example.demo.services.CalculatorService;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
    
    @RepeatedTest(10) //this allows the test to be repeated 10 times
    @DisplayName("Repeated Test example")
    public void repeatedSumTestExample(RepetitionInfo repetitionInfo){
	
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
}