package br.com.alura.api.medico;

import br.com.alura.api.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

// Classe JPA
@Table(name = "medicos")
@Entity(name = "Medico")
// Lombok
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome; 
	private String email;
	private String telefone;
	private String crm; 
	//private Especialidade especialidade;
	//private Endereco endereco;
	
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	
	@Embedded
	private Endereco endereco;
	
	// Construtor
	public Medico(DadosCadastroMedico dados) {
		this.nome = dados.nome();
		this.email = dados.email();
		this.telefone = dados.telefone();
		this.crm = dados.crm();
		this.especialidade = dados.especialidade();
		this.endereco = new Endereco(dados.endereco());
	}
	
	public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
		if(dados.nome() != null) {
			this.nome = dados.nome();
		}
		if(dados.telefone() != null) {
			this.telefone = dados.telefone();
		}
		if(dados.endereco() != null) {
			this.endereco.atualizarInformacoes(dados.endereco());
		}
	}

}
