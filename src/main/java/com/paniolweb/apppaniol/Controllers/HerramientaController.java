package com.paniolweb.apppaniol.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.paniolweb.apppaniol.entities.Herramienta;
import com.paniolweb.apppaniol.service.HerramientaService;

@RestController
@RequestMapping("/herramientas")
public class HerramientaController {

    @Autowired
    private HerramientaService herramientaService;

    @GetMapping
    public ResponseEntity<List<Herramienta>> getAllHerramientas() {
        List<Herramienta> herramientas = herramientaService.obtenerTodas();
        return ResponseEntity.ok(herramientas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Herramienta> getHerramientaById(@PathVariable Long id) {
        Herramienta herramienta = herramientaService.obtenerPorId(id);
        return ResponseEntity.ok(herramienta);
    }

    @PostMapping
    public ResponseEntity<Herramienta> createHerramienta(@RequestBody Herramienta herramienta) {
        Herramienta nueva = herramientaService.crearHerramienta(herramienta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nueva);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Herramienta> updateHerramienta(@PathVariable Long id,
            @RequestBody Herramienta herramientaDetails) {
        Herramienta actualizada = herramientaService.actualizar(id, herramientaDetails);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHerramienta(@PathVariable Long id) {
        herramientaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}