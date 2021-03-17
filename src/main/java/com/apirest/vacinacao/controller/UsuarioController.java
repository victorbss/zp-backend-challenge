package com.apirest.vacinacao.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.vacinacao.model.Usuario;
import com.apirest.vacinacao.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@PostMapping
	public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario) {
		try {
			usuarioRepository.save(usuario);
			URI location = URI.create(String.format("/usuarios/%s", usuario.getId()));
			return ResponseEntity.created(location).body(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
	}
}
