package com.github.viniciusvk1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.viniciusvk1.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByUsuario(String usuario);

}