package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CalculatorService;
import com.example.demo.services.URL;
import java.util.Queue;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class MainController {
	
	@Autowired
	CalculatorService calculatorService;
	
	public MainController(CalculatorService calculatorService) {
		super();
		this.calculatorService = calculatorService;
	}

	@PostMapping(URL.POST)
	@ResponseBody
	public Double calculate (@RequestBody Queue<String> inputs) {
		
                return calculatorService.operate(inputs).get();  
	}
}	