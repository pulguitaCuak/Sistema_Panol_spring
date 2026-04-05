package com.paniolweb.apppaniol.service;

import java.util.List;

import com.paniolweb.apppaniol.entities.Herramienta;


public interface HerramientaService {

    List<Herramienta> obtenerTodas();
    Herramienta obtenerPorId(Long Id);
    Herramienta crearHerramienta(Herramienta herramienta);
    Herramienta actualizar(Long id, Herramienta herramienta);
    void eliminar (Long id);

}
