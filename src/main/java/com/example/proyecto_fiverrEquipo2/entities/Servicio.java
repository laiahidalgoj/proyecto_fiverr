package com.example.proyecto_fiverrEquipo2.entities;

import java.util.List;

public class Servicio {

    private Long id;
    private List<String> tipoWeb;
    private List<String> herramientas;
    private List<String> servicios;

    public Servicio(Long id, List<String> tipoWeb, List<String> herramientas, List<String> servicios) {
        this.id = id;
        this.tipoWeb = tipoWeb;
        this.herramientas = herramientas;
        this.servicios = servicios;
    }
}
