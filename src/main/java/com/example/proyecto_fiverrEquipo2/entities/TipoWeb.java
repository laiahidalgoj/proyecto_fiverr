package com.example.proyecto_fiverrEquipo2.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="tiposWeb")
public class TipoWeb {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(name = "tiposWeb",
//            joinColumns = {
//                    @JoinColumn(name = "IdTipoWeb", referencedColumnName = "id")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "IdServicio", referencedColumnName = "id")
//            })

    // atributo
    private String nombre;

    //constructor
    public TipoWeb(String nombre) {
        this.nombre = nombre;
    }

    //getter y setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<Servicio> getServicios() {
//        return servicios;
//    }
//
//    public void setServicios(List<Servicio> servicios) {
//        this.servicios = servicios;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    // métodos
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TipoWeb tipoWeb = (TipoWeb) obj;
        return Objects.equals(nombre, tipoWeb.nombre);

    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
