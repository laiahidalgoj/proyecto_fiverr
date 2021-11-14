package com.example.proyecto_fiverrEquipo2.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Entidad que gestiona la tabla de vendedores de la base de datos
 */


@Entity
@Table(name = "Vendedores")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vendedor", fetch = FetchType.EAGER)
    @JoinTable(name="ServicioVendedor",
        joinColumns = {
        @JoinColumn(name="IdVendedor", referencedColumnName = "id")
    },
            inverseJoinColumns = {
            @JoinColumn(name="IdServicio", referencedColumnName = "id")
            })

    // Atributos
    private String titulo;
    private String nombre;
    private Integer antiguedad;
    private String descripcion;
    private String email;
    private String nivel;
    private String idioma;
    private String residencia;
    private String tipoWeb;
    private String servicios;
    private String herramientas;

    // constructores

    public Vendedor(){};

    public Vendedor(Long id, String titulo, String nombre, Integer antiguedad, String descripcion, String email, String nivel, String idioma, String residencia, String tipoWeb, String servicios, String herramientas) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.descripcion = descripcion;
        this.email = email;
        this.nivel = nivel;
        this.idioma = idioma;
        this.residencia = residencia;
        this.tipoWeb = tipoWeb;
        this.servicios = servicios;
        this.herramientas = herramientas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(Integer antiguedad) {
        this.antiguedad = antiguedad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    public String getTipoWeb() {
        return tipoWeb;
    }

    public void setTipoWeb(String tipoWeb) {
        this.tipoWeb = tipoWeb;
    }

    public String getServicios() {
        return servicios;
    }

    public void setServicios(String servicios) {
        this.servicios = servicios;
    }

    public String getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(String herramientas) {
        this.herramientas = herramientas;
    }
}
