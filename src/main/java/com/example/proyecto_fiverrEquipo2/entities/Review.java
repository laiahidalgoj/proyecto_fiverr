package com.example.proyecto_fiverrEquipo2.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descripcion;
    private Date fecha_Publicacion;

    @Column()
    private int puntuacion;


    @ManyToOne
    private Vendedor vendedores;

    @ManyToOne
    private Trabajo trabajos;


    // CONSTRUCTORES

    public Review(){}

    public Review(Long id, int puntuacion, String descripcion, Trabajo trabajos, Vendedor vendedores) {
        this.id = id;
        this.puntuacion = puntuacion;
        this.descripcion = descripcion;
        this.trabajos = trabajos;
        this.vendedores = vendedores;
    }

    //GETTERS Y SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_Publicacion() {
        return fecha_Publicacion;
    }

    public void setFecha_Publicacion(Date fecha_Publicacion) {
        this.fecha_Publicacion = fecha_Publicacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Vendedor getVendedores() {
        return vendedores;
    }

    public void setVendedores(Vendedor vendedores) {
        this.vendedores = vendedores;
    }

    public Trabajo getTrabajos() {
        return trabajos;
    }

    public void setTrabajos(Trabajo trabajos) {
        this.trabajos = trabajos;
    }


}