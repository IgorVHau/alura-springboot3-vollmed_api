package br.com.alura.api.domain.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
		
		@NotBlank
		String logradouro, 
		
		@NotBlank
		String bairro, 
		
		@NotBlank
		@Pattern(regexp = "\\d{8}")
		String cep, 
		
		@NotBlank
		String cidade, 
		
		@NotBlank
		@Pattern(regexp = "\\w{2}")
		String uf, 
		
		String complemento, 
		
		String numero
		) {

}
