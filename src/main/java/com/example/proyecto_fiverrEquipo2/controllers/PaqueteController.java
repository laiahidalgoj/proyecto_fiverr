package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.repository.PaquetesRepository;
import com.example.proyecto_fiverrEquipo2.repository.ServicioRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaqueteController {

    private VendedorRepository vendedorRepository;
    private PaquetesRepository paquetesRepository;
    private ServicioRepository servicioRepository;

    public PaqueteController(VendedorRepository vendedorRepository, PaquetesRepository paquetesRepository, ServicioRepository servicioRepository) {
        this.vendedorRepository = vendedorRepository;
        this.paquetesRepository = paquetesRepository;
        this.servicioRepository = servicioRepository;
    }
}
