package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.entities.Trabajos;
import com.example.proyecto_fiverrEquipo2.repository.PaquetesRepository;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrabajoController {

    private VendedorRepository vendedorRepository;
    private PaquetesRepository paquetesRepository;
    private TrabajoRepository trabajoRepository;

    public TrabajoController(VendedorRepository vendedorRepository, PaquetesRepository paquetesRepository, TrabajoRepository trabajoRepository) {
        this.vendedorRepository = vendedorRepository;
        this.paquetesRepository = paquetesRepository;
        this.trabajoRepository = trabajoRepository;
    }

    /**
     * Buscar todos los vendedores en BBDD
     */

    @GetMapping("/api/servicios")
    public List<Trabajos> findAll(){
        return trabajoRepository.findAll();
    }
}
