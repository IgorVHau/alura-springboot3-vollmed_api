package br.com.alura.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.api.paciente.DadosCadastroPaciente;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	public void cadastrar(@RequestBody DadosCadastroPaciente dados) {
		
	}

}
