package com.grupo01.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo01.spring.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
