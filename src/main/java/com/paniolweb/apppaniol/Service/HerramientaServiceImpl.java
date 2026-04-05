package com.paniolweb.apppaniol.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paniolweb.apppaniol.Entities.Herramienta;
import com.paniolweb.apppaniol.Repositories.HerramientaRepository;

@Service
public class HerramientaServiceImpl implements HerramientaService {

    @Autowired
    private HerramientaRepository herramientaRepository;

    @Override
    public List<Herramienta> obtenerTodas() {
        return herramientaRepository.findAll();
    }

    @Override
    public Herramienta obtenerPorId(Long id) {
        return herramientaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la herramienta con id " + id));
    }

    @Override
    public Herramienta crearHerramienta(Herramienta herramienta) {
        return herramientaRepository.save(herramienta);
    }

    @Override
    public Herramienta actualizar(Long id, Herramienta herramientaDetails) {
        Herramienta herramienta = herramientaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la herramienta con id " + id));

        herramienta.setNombre(herramientaDetails.getNombre());
        herramienta.setCantidad(herramientaDetails.getCantidad());

        return herramientaRepository.save(herramienta);
    }

    @Override
    public void eliminar(Long id) {
        Herramienta herramienta = herramientaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró la herramienta con id " + id));

        herramientaRepository.delete(herramienta);
    }
}