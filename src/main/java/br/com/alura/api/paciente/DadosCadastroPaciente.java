package br.com.alura.api.paciente;

import br.com.alura.api.endereco.DadosEndereco;
import jakarta.validation.constraints.*;
import jakarta.validation.*;

public record DadosCadastroPaciente(
		
		@NotBlank
		String nome,
		
		@NotBlank
		@Email
		String email,
		
		@NotBlank
		@Pattern(regexp = "(?:(^\\+\\d{2})?)(?:([1-9]{2})|([0-9]{3})?)(\\d{4,5})(\\d{4})")
		String telefone,
		
		@NotBlank
		@Pattern(regexp = "[0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[\\.]?[-]?[0-9]{2}")
		String cpf,
		
		@NotNull
		@Valid
		DadosEndereco endereco) {

}
