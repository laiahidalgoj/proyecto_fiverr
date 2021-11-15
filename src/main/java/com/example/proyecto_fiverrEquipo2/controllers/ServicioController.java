package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.entities.Servicio;
import com.example.proyecto_fiverrEquipo2.entities.Vendedor;
import com.example.proyecto_fiverrEquipo2.repository.PaquetesRepository;
import com.example.proyecto_fiverrEquipo2.repository.ServicioRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ServicioController {

    private VendedorRepository vendedorRepository;
    private PaquetesRepository paquetesRepository;
    private ServicioRepository servicioRepository;

    public ServicioController(VendedorRepository vendedorRepository, PaquetesRepository paquetesRepository, ServicioRepository servicioRepository) {
        this.vendedorRepository = vendedorRepository;
        this.paquetesRepository = paquetesRepository;
        this.servicioRepository = servicioRepository;
    }

    /**
     * Buscar todos los vendedores en BBDD
     */

    @GetMapping("/api/servicios")
    public List<Servicio> findAll(){
        return servicioRepository.findAll();
    }
}
