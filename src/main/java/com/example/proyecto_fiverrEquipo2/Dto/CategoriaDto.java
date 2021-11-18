package com.example.proyecto_fiverrEquipo2.Dto;

import com.example.proyecto_fiverrEquipo2.entities.Trabajo;
import com.example.proyecto_fiverrEquipo2.entities.Vendedor;

import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

public class CategoriaDto {

    @Id
    private Long id;

    private String nombre;
    private String descripcion;
    private String puntuacion;
    private Set<Vendedor> vendedores = new HashSet<>();
    private Set<Trabajo> trabajo = new HashSet<>();

    public CategoriaDto() {}

    public CategoriaDto(Long id, String nombre, String descripcion, String puntuacion, Set<Vendedor> vendedores) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
        this.vendedores = vendedores;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Set<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(Set<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public Set<Trabajo> getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Set<Trabajo> trabajo) {
        this.trabajo = trabajo;
    }
}
