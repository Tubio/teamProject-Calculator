package com.example.demo.services;

import java.util.Queue;
import org.springframework.stereotype.Service;

@Service("calculatorService")
public class CalculatorService {
	
    //pre: Queue must be alterned between a number and a symbol
    //post: returns the total result operating from left to right, 
    //null in case of an invalid operation
    public Double operate (Queue<String> inputs) {
        
        Double result = Double.parseDouble(inputs.remove());
        String operator;
        Double second;
        
        do{
            operator = inputs.remove();
            second = Double.parseDouble(inputs.remove());
            result = getResult(result,operator,second);
            
        }while(!inputs.isEmpty());
            
        return result;
    }
    
    //pre: operator must be: "+", "-", "*", "/".
    //post: returns the result, null if the operation is invalid.
    public Double getResult(Double number1, String operator, Double number2) {
		
	Double result = 0D;
		
	if	(operator.equals("+"))
            result = number1 + number2;
		
	else if (operator.equals("-"))
            result = number1 - number2;
		
	else if (operator.equals("*"))
            result = number1 * number2;
		
	else if (operator.equals("/")){
            
            if(number2 == 0){
                
                System.out.println("Can't divide by zero");
                throw new ArithmeticException("Can't divide by zero");
            }
            result = number1 / number2;
        }
        else result = null; //invalid operation
		
	return result;
    }
}