package com.paniolweb.apppaniol.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class RegistroHistorico {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne
@JoinColumn(name = "prestamoId")
protected Prestamo prestamo;

private LocalDateTime fechaPrestamo;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public Prestamo getPrestamo() {
    return prestamo;
}

public void setPrestamo(Prestamo prestamo) {
    this.prestamo = prestamo;
}

public LocalDateTime getFechaPrestamo() {
    return fechaPrestamo;
}

public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
    this.fechaPrestamo = fechaPrestamo;
}

@PrePersist
protected void onCreate(){
this.fechaPrestamo = LocalDateTime.now();
}
private String observaciones;

public String getObservaciones() {
    return observaciones;
}

public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
}
}
