package com.marcus.paciente.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcus.paciente.model.Paciente;
import com.marcus.paciente.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository pacienteRepository;

	public Paciente salvar(Paciente paciente) {
		return pacienteRepository.save(paciente);
	}

	public Paciente buscarCpf(String cpf) {
		
		return pacienteRepository.findByCpf(cpf);
	}

	public Paciente buscarNomeMae(String nomeMae) {
		
		return pacienteRepository.findByNomeMae(nomeMae);
	}

	public Paciente buscarRua(String rua) {
		
		return pacienteRepository.findByEnderecoRua(rua);
	}

	public void deletar(Long id) {

		pacienteRepository.deleteById(id);	
	}

	public void editar(Paciente paciente, Long id) {
		
		verificarContatoPorId(id);
		pacienteRepository.save(paciente);		
	}

	private void verificarContatoPorId(Long id) {
		pacienteRepository.findById(id);
		

		
	}
}
