package com.paniolweb.apppaniol.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import com.paniolweb.apppaniol.enums.unidadMedida;
@Entity
public class Insumo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotBlank(message ="el nombre no puede estar vacio")
private String nombre;
@Min(value = 0, message = "la cantidad tiene que ser mayor a 0")
private int cantidad;

@Enumerated(EnumType.STRING)
private unidadMedida unidadMedida;

public Long getId() {
    return id;
}
public void setId(Long id) {
    this.id = id;
}
public String getNombre() {
    return nombre;
}
public void setNombre(String nombre) {
    this.nombre = nombre;
}
public int getCantidad() {
    return cantidad;
}
public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
}
public unidadMedida getUnidadMedida() {
    return unidadMedida;
}
public void setUnidadMedida(unidadMedida unidadMedida) {
    this.unidadMedida = unidadMedida;
}
}

