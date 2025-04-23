package br.com.alura.api.paciente;

import br.com.alura.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;
	private String cpf;
	
	@Embedded
	private Endereco endereco;
	private boolean ativo;

}
