package com.example.demo.services;

import java.util.Queue;
import org.springframework.stereotype.Service;

@Service("calculatorService")
public class CalculatorService {
	
    //pre: Inputs should be altered between a number and a symbol,
    //     starting with the number
    //post: returns the result working from left to right (does not consider
    //      math priorities)
    public Double getResult(Queue<String> inputs) {
		
        //result is the first number in the queue.
	Double result = Double.parseDouble(inputs.remove());
        String operator = inputs.remove();
        Double secondNumber = Double.parseDouble(inputs.remove());
                
        //modifies the result until the queue ends.
        while(!inputs.isEmpty()){
                    
            result = operate(result,operator,secondNumber);
                    
            operator = inputs.remove();
            secondNumber = Double.parseDouble(inputs.remove());
        }       
	return result;
	}
    
    public Double operate(Double number1, String operator, Double number2) {
		
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
