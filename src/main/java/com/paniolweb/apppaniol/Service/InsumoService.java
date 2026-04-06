package com.paniolweb.apppaniol.service;

import java.util.List;

import com.paniolweb.apppaniol.entities.Insumo;

public interface InsumoService {

    List<Insumo> ObtenerTodos();
    Insumo obtenerPorId(Long id);
    Insumo crearInsumo(Insumo Insumo);
    Insumo actualizar(Long id, Insumo insumo);
    void eliminar (Long id);
}
