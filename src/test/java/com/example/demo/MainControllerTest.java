package com.example.demo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Queue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controllers.MainController;
import com.example.demo.services.CalculatorService;

//WebMvcTest hace que no se cargue todo el contexto, solo el web layer que queremos probar (en este caso defino que es el controlador principal)
@WebMvcTest(MainController.class)
@AutoConfigureMockMvc
public class MainControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	CalculatorService calculatorService;
	
	private Queue<String> inputs;
	
	@Test
	public void controllerCallTest() throws Exception{
		//stub del metodo getresult, lo que queremos probar es el controlador
		when(calculatorService.operate(inputs)).thenReturn(3d);
		
		this.mockMvc.perform(
			post("/calculate")
				.contentType(MediaType.APPLICATION_JSON)
				.content("prueba")
			.andExpect(status().isOk());
			
	}
}
