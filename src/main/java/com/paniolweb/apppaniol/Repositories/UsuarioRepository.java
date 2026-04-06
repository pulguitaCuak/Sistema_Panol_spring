package com.paniolweb.apppaniol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paniolweb.apppaniol.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
