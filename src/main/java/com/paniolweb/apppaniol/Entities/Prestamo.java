package com.paniolweb.apppaniol.entities;

import java.time.LocalDateTime;

import com.paniolweb.apppaniol.enums.EstadoPrestamo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;

@Entity
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "usuarioId")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "carritoId")
    private Carrito carrito;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Carrito getCarrito() {
        return carrito;
    }
    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }
    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }
    public EstadoPrestamo getEstado() {
        return estado;
    }
    public void setEstado(EstadoPrestamo estado) {
        this.estado = estado;
    }
    @Column
    private LocalDateTime fechaPrestamo;

    @Enumerated(EnumType.STRING)
    private EstadoPrestamo estado;
    @PrePersist
    protected void onCreate() {
        this.fechaPrestamo = LocalDateTime.now();
        this.estado = EstadoPrestamo.ACTIVO;
    }
}
