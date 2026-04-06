package com.paniolweb.apppaniol.service;

import java.util.List;

import com.paniolweb.apppaniol.entities.Usuario;
import com.paniolweb.apppaniol.enums.cargoUsuario;

public interface UsuarioService {
    List<Usuario> ObtenerTodos();

    Usuario obtenerPorId(Long id);

    Usuario crearUsuario(Usuario Usuario);

    Usuario actualizar(Long id, Usuario usuario);

    void eliminar(Long id);

    Usuario cambiarCargo(Long id, cargoUsuario cargo);
}
