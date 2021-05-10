package com.marcus.paciente.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcus.paciente.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

	Paciente findByCpf(String cpf);

	Paciente findByNomeMae(String nomeMae);

	Paciente findByEnderecoRua(String rua);

}
