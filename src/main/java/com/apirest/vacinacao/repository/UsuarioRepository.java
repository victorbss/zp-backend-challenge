package com.apirest.vacinacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.vacinacao.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
