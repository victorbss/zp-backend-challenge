package com.apirest.vacinacao.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.vacinacao.model.Vacina;
import com.apirest.vacinacao.repository.VacinaRepository;

@RestController
@RequestMapping("/vacinacao")
public class VacinaController {
	
	@Autowired
	private VacinaRepository vacinaRepository;
	
	@PostMapping
	public ResponseEntity<Vacina> cadastrar(@RequestBody Vacina vacina) {
		try {
			vacinaRepository.save(vacina);
			URI location = URI.create(String.format("/vacinacao/%s", vacina.getId()));
			return ResponseEntity.created(location).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
