package com.example.demo;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.LinkedList;
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
import com.google.gson.Gson;
import java.util.Optional;

//WebMvcTest hace que no se cargue todo el contexto, solo el web layer que queremos probar (en este caso defino que es el controlador principal)
@WebMvcTest(MainController.class)
@AutoConfigureMockMvc
public class MainControllerTest {
	
	@Autowired
	MockMvc mockMvc; //Este objeto nos permite testear un controlador sin necesidad de iniciar la aplicacion
	
	
	@MockBean CalculatorService calculatorService;
	
	Queue<String> myQueue = new LinkedList<>();
	
	//Gson es una libreria que nos ayuda a transformar objetos java en JSON y viceversa
	Gson gson = new Gson();
	

	@Test	
	public void controllerCallTest() throws Exception{
		
		
		myQueue.add("mock");	
		String request = gson.toJson(myQueue);
		
		//stub del metodo operate, lo que queremos probar es el controlador
		when(calculatorService.operate(myQueue)).thenReturn(Optional.of(3d));
		
		this.mockMvc.perform(
			post("/calculate")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request))
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("3")));
			
				
	}
	
}
