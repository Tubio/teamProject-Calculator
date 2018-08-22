package com.example.demo;

import static org.junit.Assert.assertNotNull;

//Asegurarse de importar org.junit.jupiter, sino toma JUnit 4
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controllers.MainController;
import com.example.demo.services.CalculatorService;
import java.util.LinkedList;
import java.util.Queue;

@SpringBootTest
public class TeamProyectCalculatorApplicationTest{

	@Autowired
	private MainController mainController;

	@Test
	public void contextLoads() throws Exception {
			
		assertNotNull(mainController);
		
	}
}
