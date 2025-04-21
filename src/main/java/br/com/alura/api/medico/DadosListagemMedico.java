package br.com.alura.api.medico;

public record DadosListagemMedico(String nome, String email, String crm, Especialidade especialidade) {
	
	// Construtor para converter Medico para DadosListagemMedico
	public DadosListagemMedico(Medico medico) {
		this(medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
		//this.nome = medico.getNome();
		//this.email = medico.getEmail();
		//this.crm = medico.getCrm();
		//this.especialidade = medico.getEspecialidade();
	}

}
