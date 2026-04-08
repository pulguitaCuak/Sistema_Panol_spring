package com.paniolweb.apppaniol.service;

import java.util.List;

import com.paniolweb.apppaniol.entities.Carrito;

public interface CarritoService {

    List<Carrito> obtenerTodos();

    Carrito agregarItem(Long id, String tipo, int cantidad, Long carritoId);

    void eliminarCarrito(Long id);

    Carrito buscarPorUsuario(Long usuarioId);

    void eliminarItemDelCarrito(Long carritoId, Long itemId);
}
