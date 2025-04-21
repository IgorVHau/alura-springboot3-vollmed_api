package br.com.alura.api.medico;

import br.com.alura.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
		@NotNull
		Long id, 
		String nome,
		String telefone, 
		DadosEndereco endereco) {
	
}
