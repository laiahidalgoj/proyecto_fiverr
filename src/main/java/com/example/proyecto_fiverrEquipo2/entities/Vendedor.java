package com.example.proyecto_fiverrEquipo2.entities;

import javax.persistence.*;
import java.util.ArrayList;
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

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "ServicioVendedor",
            joinColumns = {
                    @JoinColumn(name = "IdVendedor", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "IdServicio", referencedColumnName = "id")
            })
    private List<Trabajos> trabajos = new ArrayList<>();


    // Atributos
    private String titulo;
    private String nombre;
    private Integer antiguedad;
    private String descripcion;
    private String email;
    private String nivel;
    private String idioma;
    private String residencia;

    // constructores
    public Vendedor() {
    }

    public Vendedor(Long id, String titulo, String nombre, Integer antiguedad, String descripcion, String email, String nivel, String idioma, String residencia) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.descripcion = descripcion;
        this.email = email;
        this.nivel = nivel;
        this.idioma = idioma;
        this.residencia = residencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Trabajos> getServicios() {
        return trabajos;
    }

    public void setServicios(List<Trabajos> trabajos) {
        this.trabajos = trabajos;
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

    public void addServicio(Trabajos trabajos){
        this.trabajos.add(trabajos);
        trabajos.getVendedores().add(this);
    }
    @Override
    public String toString() {
        return "Vendedor{" +
                "id=" + id +
                ", servicios=" + trabajos +
                ", titulo='" + titulo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", antiguedad=" + antiguedad +
                ", descripcion='" + descripcion + '\'' +
                ", email='" + email + '\'' +
                ", nivel='" + nivel + '\'' +
                ", idioma='" + idioma + '\'' +
                ", residencia='" + residencia + '\'' +
                '}';
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