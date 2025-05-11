package br.com.alura.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.api.domain.consulta.DadosAgendamentoConsulta;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@PostMapping
	public ResponseEntity agendar(
			//@RequestBody @Valid DadosAgendamentoConsulta dados
			) {
		System.out.println("Função para consulta de agendamento.");
		return ResponseEntity.ok(new DadosAgendamentoConsulta(null, null, null, null));
	}

}
