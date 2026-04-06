package com.paniolweb.apppaniol.service;

import com.paniolweb.apppaniol.entities.Insumo;
import com.paniolweb.apppaniol.exceptions.ResourceNotFoundException;
import com.paniolweb.apppaniol.repositories.InsumoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsumoServiceImpl implements InsumoService {

    @Autowired
    private InsumoRepository InsumoRepository;

    @Override
    public List<Insumo> ObtenerTodos() {
        return InsumoRepository.findAll();
    }

    @Override
    public Insumo obtenerPorId(Long id) {
        return InsumoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el insumo con la id " + id));
    }

    @Override
    public Insumo crearInsumo(Insumo Insumo) {
        return InsumoRepository.save(Insumo);
    }

    @Override
    public Insumo actualizar(Long id, Insumo insumoDetails) {
        Insumo Insumo = InsumoRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("No se encontro insumo para actualizar con la ID " + id));
        Insumo.setNombre(insumoDetails.getNombre());
        Insumo.setCantidad(insumoDetails.getCantidad());
        Insumo.setUnidadMedida(insumoDetails.getUnidadMedida());
        return InsumoRepository.save(Insumo);

    }

    @Override
    public void eliminar(Long id) {
        Insumo insumo = InsumoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro el insumo con id " + id));
        InsumoRepository.delete(insumo);
    }
}
