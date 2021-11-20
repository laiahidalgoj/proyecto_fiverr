package com.example.proyecto_fiverrEquipo2.entities;

import com.example.proyecto_fiverrEquipo2.Idioma;
import com.example.proyecto_fiverrEquipo2.Nivel;
import com.example.proyecto_fiverrEquipo2.Pais;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name="trabajos")
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MANY TO MANY TRABAJO > VENDEDOR
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "TrabajoVendedor",
            joinColumns = {
                    @JoinColumn(name = "IdTrabajo", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "IdVendedor", referencedColumnName = "id")
            })
    private Set<Vendedor> vendedores = new HashSet<>();

    // MANY TO MANY TRABAJO > CATEGORIAS
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "TrabajoCategoria",
            joinColumns = {
                    @JoinColumn(name = "IdTrabajo", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "IdCategoria", referencedColumnName = "id")
            })
    private Set<Categoria> categorias = new HashSet<>();

    @Column(name = "precio")
    private Double precio;

    @Enumerated
    private Idioma idiomas;

    @Enumerated
    private Pais paises;

    @Enumerated
    private Nivel niveles;

    private String nombre;
    private String descripcion;
    private String imagen;
    private String categoria;
    private Integer reviews;
    private LocalDate fecha_Publicacion;

    //CONSTRUCTORES

    public Trabajo() {
    }

    public Trabajo(Long id, String nombre, String descripcion, String imagen, Double precio, LocalDate fecha_Publicacion, Idioma idiomas, Pais paises){
        this.id =id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.precio = precio;
        this.fecha_Publicacion = fecha_Publicacion;
        this.idiomas = idiomas;
        this.paises = paises;
    }

    public Trabajo(Long id, String nombre, String descripcion, Double precio, Idioma idiomas, Pais paises) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.idiomas = idiomas;
        this.paises = paises;
    }

    public Trabajo(Long id, String nombre, String descripcion, Double precio, LocalDate fecha_Publicacion, Nivel niveles, Idioma idiomas, Pais paises) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
//        this.vendedores = vendedores;
//        this.categorias = categorias;
        this.precio = precio;
        this.fecha_Publicacion = fecha_Publicacion;
        this.niveles = niveles;
        this.idiomas = idiomas;
        this.paises = paises;
    }

    // ADD & REMOVE
    public void addCategoria(Categoria categoria) {
        categorias.add(categoria);
        categoria.getTrabajos().add(this);
    }

    public void removeCategoria(Categoria categoria, boolean categoriaExists) {
        categorias.remove(categoria);
        if (categoriaExists) {
            categoria.getTrabajos().remove(this);
        }
    }

    public void addVendedor(Vendedor vendedor){
        vendedores.add(vendedor);
        vendedor.getTrabajo().add(this);
    }

    public void removeVendedor(Vendedor vendedor, boolean vendedoresExists) {
        vendedores.add(vendedor);
        if (vendedoresExists) {
            vendedor.getTrabajo().remove(this);
        }
    }
        // GETTERS Y SETTERS


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(Set<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public Set<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Idioma getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Idioma idiomas) {
        this.idiomas = idiomas;
    }

    public Pais getPaises() {
        return paises;
    }

    public void setPaises(Pais paises) {
        this.paises = paises;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getReviews() {
        return reviews;
    }

    public void setReviews(Integer reviews) {
        this.reviews = reviews;
    }

    public LocalDate getFecha_Publicacion() {
        return fecha_Publicacion;
    }

    public void setFecha_Publicacion(LocalDate fecha_Publicacion) {
        this.fecha_Publicacion = fecha_Publicacion;
    }

    //MÉTODOS
        @Override
        public boolean equals (Object obj){
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Trabajo trabajo = (Trabajo) obj;
            return Objects.equals(nombre, trabajo.nombre);

        }

        @Override
        public int hashCode () {
            return getClass().hashCode();
        }
}

