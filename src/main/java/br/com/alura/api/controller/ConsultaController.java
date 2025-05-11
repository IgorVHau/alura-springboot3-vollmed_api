package br.com.alura.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@PostMapping
	public ResponseEntity agendar() {
		System.out.println("Função para consulta de agendamento.");
		return null;
	}

}
