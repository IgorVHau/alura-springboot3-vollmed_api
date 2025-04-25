package br.com.alura.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
/*import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.api.paciente.DadosCadastroPaciente;
import br.com.alura.api.paciente.DadosDetalhamentoPaciente;
import br.com.alura.api.paciente.DadosListagemPaciente;
import br.com.alura.api.paciente.Paciente;
import br.com.alura.api.paciente.PacienteRepository;

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
		
		return ResponseEntity.created(uri).body(new DadosDetalhamentoPaciente(paciente));
	}
	
	@GetMapping
	//public List<DadosListagemPaciente> listar(Paciente paciente) {
	public Page<DadosListagemPaciente> listar(Pageable paginacao) {
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPaciente::new);
	}
	
	
}
