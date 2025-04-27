package br.com.alura.api.domain.paciente;

import jakarta.validation.constraints.NotBlank;

public record DadosListagemPaciente(String nome, String email, String cpf) {

	public DadosListagemPaciente(Paciente paciente) {
		// TODO Auto-generated constructor stub
		this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
	}
	
	
}
