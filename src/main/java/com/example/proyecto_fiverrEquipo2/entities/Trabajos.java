package com.example.proyecto_fiverrEquipo2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="servicios")
public class Trabajos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "trabajos", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Vendedor> vendedores = new ArrayList<>();

    private String nombre;

    public Trabajos(){
        super();
    }

   public Trabajos(String nombre){
        this.nombre = nombre;
   }

    public Trabajos(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Trabajos trabajos = (Trabajos) obj;
        return Objects.equals(nombre, trabajos.nombre);

    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}