package com.example.demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controllers.MainController;
import com.example.demo.services.CalculatorService;

// Esta anotacion hace que no se cargue todo el contexto, solo el web layer que queremos probar (en este caso defino que es el controlador principal)
@WebMvcTest(MainController.class)
@AutoConfigureMockMvc
public class MainControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	CalculatorService calculatorService;
	
	@Test
	public void controllerCallTest() throws Exception{
		
		when(calculatorService.getResult(1d, "+", 2d)).thenReturn(3D);
	}
}
