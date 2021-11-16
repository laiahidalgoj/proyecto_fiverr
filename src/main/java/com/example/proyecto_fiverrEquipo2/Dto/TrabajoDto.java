package com.example.proyecto_fiverrEquipo2.Dto;

import com.example.proyecto_fiverrEquipo2.Idioma;
import com.example.proyecto_fiverrEquipo2.Pais;
import com.example.proyecto_fiverrEquipo2.entities.Categoria;
import com.example.proyecto_fiverrEquipo2.entities.Vendedor;

import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TrabajoDto {

        @Id
        private Long id;

        private String nombre;
        private String imagen;
        private String descripcion;
        private Integer reviews;
        private Double promedio;
        private Double precio;
        private Set<Categoria> categoria = new HashSet<>();
        private Set<Vendedor> vendedores = new HashSet<>();
        private LocalDate fecha_Publicacion;

        @Enumerated
        private Pais paises;

        @Enumerated
        private Idioma idiomas;

        public TrabajoDto() {
        }

        public TrabajoDto(Long id, String nombre, String imagen, String descripcion, Double precio, Set<Categoria> categoria, Set<Vendedor> vendedores, LocalDate fecha_Publicacion, Pais paises, Idioma idiomas) {
            this.id = id;
            this.nombre = nombre;
            this.imagen = imagen;
            this.descripcion = descripcion;
            this.precio = precio;
            this.categoria = categoria;
            this.vendedores = vendedores;
            this.fecha_Publicacion = fecha_Publicacion;
            this.paises = paises;
            this.idiomas = idiomas;
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

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public Double getPromedio() {
        return promedio;
    }

    public void setPromedio(Double promedio) {
        this.promedio = promedio;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Set<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(Set<Categoria> categoria) {
        this.categoria = categoria;
    }

    public Set<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(Set<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public LocalDate getFecha_Publicacion() {
        return fecha_Publicacion;
    }

    public void setFecha_Publicacion(LocalDate fecha_Publicacion) {
        this.fecha_Publicacion = fecha_Publicacion;
    }

    public Pais getPaises() {
        return paises;
    }

    public void setPaises(Pais paises) {
        this.paises = paises;
    }

    public Idioma getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idioma idiomas) {
        this.idiomas = idiomas;
    }
}