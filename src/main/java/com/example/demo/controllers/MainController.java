package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CalculatorService;
import com.example.demo.services.URL;
import java.util.Optional;
import java.util.Queue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MainController {
	
	@Autowired
	CalculatorService calculatorService;
	
	public MainController(CalculatorService calculatorService) {
		super();
		this.calculatorService = calculatorService;
	}

	@PostMapping("/calculate")
	public ResponseEntity<Double> calculate (@RequestBody Queue<String> inputs) {
		
            //cambiar para utilizar @RESPONSEBODY
                Optional<Double> answer = calculatorService.operate(inputs);
                
                if(answer.isPresent())
                    return new ResponseEntity<>(answer.get(),HttpStatus.ACCEPTED);
                
                else return new ResponseEntity<>(0d,HttpStatus.UNPROCESSABLE_ENTITY);
	}
}	