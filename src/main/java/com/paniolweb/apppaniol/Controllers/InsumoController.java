package com.paniolweb.apppaniol.controllers;

import com.paniolweb.apppaniol.ApppaniolApplication;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paniolweb.apppaniol.entities.Insumo;
import com.paniolweb.apppaniol.service.InsumoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/Insumos")
public class InsumoController {

    @Autowired
    private InsumoService InsumoService;

    InsumoController(ApppaniolApplication apppaniolApplication) {
    }

    @GetMapping
    public ResponseEntity<List<Insumo>> getAllInsumos() {
        List<Insumo> insumos = InsumoService.ObtenerTodos();
        return ResponseEntity.ok(insumos);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Insumo> getInsumoById(@PathVariable Long id) {
        Insumo insumos = InsumoService.obtenerPorId(id);
        return ResponseEntity.ok(insumos);
    }

    @PostMapping
    public ResponseEntity<Insumo> createHerramienta(@RequestBody Insumo insumo){
    Insumo nuevo = InsumoService.crearInsumo(insumo);
    return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Insumo> updateInsumo(@PathVariable Long id, @RequestBody Insumo insumoDetails){
    Insumo actualizado = InsumoService.actualizar(id, insumoDetails);
    return ResponseEntity.ok(actualizado);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInsumo (@PathVariable Long id){
        InsumoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
