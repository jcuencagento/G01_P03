package com.grupo01.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grupo01.spring.model.Usuario;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Operation(summary = "Ya no se usa, pero por el momento lo mantenenemos por si la funcionalidad fuera útil en el futuro."
			,deprecated = true)
	public Optional<Usuario> findByMail(@Parameter(description = "Cadena de correo a buscar en BBDD.")
			String mail);

}
