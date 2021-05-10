package com.marcus.paciente.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcus.paciente.model.Paciente;
import com.marcus.paciente.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Paciente> save(@Validated @RequestBody Paciente paciente){
		Paciente npaciente = pacienteService.salvar(paciente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(npaciente.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping("/buscar/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Paciente> buscarCpf(@PathVariable String cpf){
				
		Paciente npaciente = pacienteService.buscarCpf(cpf);
		
		return ResponseEntity.ok(npaciente);
	}
	
	@GetMapping("/buscar/nomeMae/{nomeMae}")
	public ResponseEntity<Paciente> buscarNomeMae(@PathVariable String nomeMae){
		
		Paciente npaciente = pacienteService.buscarNomeMae(nomeMae);
		
		return ResponseEntity.ok(npaciente);
	}
	
	@GetMapping("/buscar/rua/{rua}")
	public ResponseEntity<Paciente> buscarRua(@PathVariable String rua){
		
		Paciente npaciente = pacienteService.buscarRua(rua);
		
		return ResponseEntity.ok(npaciente);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<Paciente> delete(@PathVariable Long id){
		
		pacienteService.deletar(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ResponseEntity<Paciente> edit(@RequestBody Paciente paciente, @PathVariable Long id){
		pacienteService.editar(paciente, id);
	
		return ResponseEntity.accepted().build();
	}
}
