package com.example.proyecto_fiverrEquipo2.entities;

import com.example.proyecto_fiverrEquipo2.Empresa;
import com.example.proyecto_fiverrEquipo2.Nivel;
import com.example.proyecto_fiverrEquipo2.Pais;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Entidad que gestiona la tabla de vendedores de la base de datos
 */

@Entity
@Table(name = "Vendedores")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    private Empresa empresa;

    @Enumerated
    private Pais paises;

    @Enumerated
    private Nivel nivel;


    private String nombre;
    private String descripcion;
    private String imagen;
    private String email;

    @ManyToMany(mappedBy = "vendedores", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<Trabajo> trabajo = new HashSet<>();

    public Vendedor(){}

    public Vendedor(Long id, String nombre, String descripcion, Empresa empresa, Pais paises, String imagen, String email, Set<Trabajo> trabajo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.empresa = empresa;
        this.paises = paises;
        this.imagen = imagen;
        this.email = email;
        this.trabajo = trabajo;
    }

    public Vendedor(Long id, String nombre, String descripcion, Nivel nivel, String email, Empresa empresa, Pais paises){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.email = email;
        this.empresa = empresa;
        this.paises = paises;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Pais getPaises() {
        return paises;
    }

    public void setPaises(Pais paises) {
        this.paises = paises;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Trabajo> getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(Set<Trabajo> trabajo) {
        this.trabajo = trabajo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Vendedor)) return true;
        return id != null && id.equals(((Vendedor) obj).getId());

    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}