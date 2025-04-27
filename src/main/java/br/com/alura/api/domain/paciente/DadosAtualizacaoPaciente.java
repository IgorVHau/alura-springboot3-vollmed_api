package br.com.alura.api.domain.paciente;

import br.com.alura.api.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public record DadosAtualizacaoPaciente(
		
		@NotNull
		Long id,
		String nome, 
		String telefone, 
		DadosEndereco endereco
		) {
	
}
