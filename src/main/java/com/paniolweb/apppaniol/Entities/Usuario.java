package com.paniolweb.apppaniol.entities;

import java.time.LocalDateTime;

import com.paniolweb.apppaniol.enums.EstadoUsuario;
import com.paniolweb.apppaniol.enums.cargoUsuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El Usuario debe tener un nombre")
    private String nombre;
    @NotBlank(message = "El Usuario debe tener un apellido")
    private String apellido;
    @NotBlank(message = "El Usuario debe tener un Gmail")
    private String gmail;
    @NotNull(message = "El Usuario debe tener un DNI")
    private Long dni;
    @NotBlank(message = "El Usuario debe tener una contraseña")
    private String contrasena;
    @NotEmpty
    private EstadoUsuario estado;
    @Enumerated
    private cargoUsuario cargo;

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }

    public cargoUsuario getCargo() {
        return cargo;
    }

    public void setCargo(cargoUsuario cargo) {
        this.cargo = cargo;
    }

    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @PrePersist
    protected void onCreate() {
        this.fechaCreacion = LocalDateTime.now();
    }

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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}