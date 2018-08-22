package com.example.demo.services;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import static jdk.nashorn.internal.runtime.JSType.isNumber;
import org.springframework.stereotype.Service;

@Service("calculatorService")
public class CalculatorService {
	
    //pre: Queue must be alterned between a number and a symbol
    //post: returns the total result operating from left to right, 
    //null in case of an invalid operation
    public Optional<Double> operate (Queue<String> inputs) {
        
        Optional<Double> operationValue = Optional.empty();
        
        if(validQueue(inputs)) {
            
            Double result = Double.parseDouble(inputs.remove());
            String operator;
            Double second;

            do{
                operator = inputs.remove();
                second = Double.parseDouble(inputs.remove());
                result = getResult(result,operator,second);

            }while(!inputs.isEmpty());
            
            operationValue = Optional.of(result);
            
        }else throw new IllegalArgumentException();
        
        return operationValue;
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
        else result = 0d; //invalid operation
		
	return result;
    }
    
    //pre: --
    //post: returns true if the queue meets the Calculator Queue conditions
    private Boolean validQueue(Queue<String> queue) {
 
        boolean valid = false;
        
        //multiple of 3
        if(queue.size() % 2 != 0)
            if(validCharacters(queue))
                valid = true;
        
        return valid;
    }
    
    //pre: --
    //post: returns true if the characters are alterned between number and
    //      operator.
    private Boolean validCharacters(Queue<String> queue) {
        
        Queue<String> queueCopy = new LinkedList<>(queue);
        Boolean valid = true;
        String character;
        int counter = 0;
        
        while(valid && !queueCopy.isEmpty()) {
            
            counter++;
            character = queueCopy.remove();
            
            //pair positions for operators, unpair for numbers
            if(counter%2 == 0) {
                
                if(!validOperator(character))
                    valid = false;
            }
            else{
                
                if(!validNumber(character))
                    valid = false;
            }
        }
        return valid;
    }
    
    private Boolean validOperator(String character) {
        
        Boolean valid = false;
        
        if(character.equals("+") || character.equals("-") ||
           character.equals("*") || character.equals("/"))
            
            valid = true;
        
        return valid;
    }

    private Boolean validNumber(String character) {
        
        Boolean valid = true;
        
        try{
            Double.parseDouble(character);
        }
        catch(Exception e){
            
            valid = false;
        }
        
        return valid;
    }
}