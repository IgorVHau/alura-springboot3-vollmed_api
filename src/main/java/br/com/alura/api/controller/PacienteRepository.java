package br.com.alura.api.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.api.paciente.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
