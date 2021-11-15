package com.example.proyecto_fiverrEquipo2.entities;

import javax.persistence.*;

@Entity
@Table(name = "Paquetes")
public class Reseñas {

    @Id
    private Long id;
    private Long idVendedor;

    private String tipoPaquete;
    private Integer numeroPaginas;
    private Boolean actualizaciones;
    private Integer numeroRevisiones;
    private Boolean archivosFuente;
    private Integer tiempoEntrega;
    private Double precio;

    public Reseñas(Long id, Long idVendedor, String tipoPaquete, Integer numeroPaginas, Boolean actualizaciones, Integer numeroRevisiones, Boolean archivosFuente, Integer tiempoEntrega, Double precio) {
        this.id = id;
        this.idVendedor = idVendedor;
        this.tipoPaquete = tipoPaquete;
        this.numeroPaginas = numeroPaginas;
        this.actualizaciones = actualizaciones;
        this.numeroRevisiones = numeroRevisiones;
        this.archivosFuente = archivosFuente;
        this.tiempoEntrega = tiempoEntrega;
        this.precio = precio;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public void Long getIdVendedor() {
//        return idVendedor;
//    }

    public void setIdVendedor(Long idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getTipoPaquete() {
        return tipoPaquete;
    }

    public void setTipoPaquete(String tipoPaquete) {
        this.tipoPaquete = tipoPaquete;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(Integer numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public Boolean getActualizaciones() {
        return actualizaciones;
    }

    public void setActualizaciones(Boolean actualizaciones) {
        this.actualizaciones = actualizaciones;
    }

    public Integer getNumeroRevisiones() {
        return numeroRevisiones;
    }

    public void setNumeroRevisiones(Integer numeroRevisiones) {
        this.numeroRevisiones = numeroRevisiones;
    }

    public Boolean getArchivosFuente() {
        return archivosFuente;
    }

    public void setArchivosFuente(Boolean archivosFuente) {
        this.archivosFuente = archivosFuente;
    }

    public Integer getTiempoEntrega() {
        return tiempoEntrega;
    }

    public void setTiempoEntrega(Integer tiempoEntrega) {
        this.tiempoEntrega = tiempoEntrega;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


}