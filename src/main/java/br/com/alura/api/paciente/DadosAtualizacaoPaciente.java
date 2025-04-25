package br.com.alura.api.paciente;

import br.com.alura.api.endereco.DadosEndereco;
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
