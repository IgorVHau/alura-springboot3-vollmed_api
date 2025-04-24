package br.com.alura.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
/*import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.api.paciente.DadosCadastroPaciente;
import br.com.alura.api.paciente.DadosListagemPaciente;
import br.com.alura.api.paciente.Paciente;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
	
	@Autowired
	private PacienteRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody DadosCadastroPaciente dados, UriComponentsBuilder uribuilder) {
		var paciente = new Paciente(dados);
		repository.save(paciente);
		
		var uri = uribuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public List<DadosListagemPaciente> listar(Paciente paciente) {
		return repository.findAll().stream().map(DadosListagemPaciente::new).toList();
	}

}
