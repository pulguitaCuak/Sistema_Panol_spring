package com.paniolweb.apppaniol.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paniolweb.apppaniol.entities.Usuario;
import com.paniolweb.apppaniol.enums.cargoUsuario;
import com.paniolweb.apppaniol.exceptions.ResourceNotFoundException;
import com.paniolweb.apppaniol.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> ObtenerTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el usuario con id " + id));
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario cambiarCargo(Long id, cargoUsuario cargo) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No se encontro usuario para actualizar con la ID " + id));
        usuario.setCargo(cargo);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizar(Long id, Usuario usuarioDetails) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No se encontro usuario para actualizar con la ID " + id));
        usuario.setNombre(usuarioDetails.getNombre());
        usuario.setApellido(usuarioDetails.getApellido());
        usuario.setDni(usuarioDetails.getDni());
        usuario.setContrasena(usuarioDetails.getContrasena());
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el usuario con la Id" + id));
        usuarioRepository.delete(usuario);
    }

}
