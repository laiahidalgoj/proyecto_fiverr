package com.example.proyecto_fiverrEquipo2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "categorias", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Trabajo> trabajos = new HashSet<>();

    // atributos
    private String nombre;
    private String descripcion;

    //constructor

    public Categoria(){}

    public Categoria(Long id, String nombre, String descripcion, Set<Trabajo> trabajos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.trabajos = trabajos;
    }

    public Categoria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Trabajo> getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(Set<Trabajo> trabajos) {
        this.trabajos = trabajos;
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

    public void removeTrabajos(Trabajo trabajo, boolean trabajoExists) {
        trabajos.remove(trabajo);
        if (trabajoExists) {
            trabajo.getCategorias().remove(this);
        }
    }

    // métodos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categoria categoria = (Categoria) obj;
        return Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }


}
