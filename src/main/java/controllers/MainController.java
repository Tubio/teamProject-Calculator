package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CalculatorService;
import com.example.demo.services.URL;

@RestController
public class MainController {
	
	@Autowired
	CalculatorService calculatorService;
	
	@PostMapping(URL.POST)
	@ResponseBody
	public Double calculate (@RequestParam Double number1,
							 @RequestParam Double number2,
							 @RequestParam String operation) {
		
		return calculatorService.getResult(number1,number2,operation);
	}
}
	
	
	