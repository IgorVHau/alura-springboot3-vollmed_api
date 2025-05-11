package br.com.alura.api.domain.consulta;

import java.time.LocalDateTime;
import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

public record DadosAgendamentoConsulta(
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long id, 
		
		Long idMedico, 
		
		@NotNull
		Long idPaciente, 
		
		@NotNull
		@Temporal(jakarta.persistence.TemporalType.DATE)
		@Future
		LocalDateTime data
		) {

}
