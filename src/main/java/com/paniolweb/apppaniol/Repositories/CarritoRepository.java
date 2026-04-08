package com.paniolweb.apppaniol.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paniolweb.apppaniol.entities.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    
    Optional<Carrito> findByUsuario_Id(Long usuarioId);
}