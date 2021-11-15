package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.repository.PaquetesRepository;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaqueteController {

    private VendedorRepository vendedorRepository;
    private PaquetesRepository paquetesRepository;
    private TrabajoRepository trabajoRepository;

    public PaqueteController(VendedorRepository vendedorRepository, PaquetesRepository paquetesRepository, TrabajoRepository trabajoRepository) {
        this.vendedorRepository = vendedorRepository;
        this.paquetesRepository = paquetesRepository;
        this.trabajoRepository = trabajoRepository;
    }
}
