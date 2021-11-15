package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.entities.Vendedor;
import com.example.proyecto_fiverrEquipo2.repository.PaquetesRepository;
import com.example.proyecto_fiverrEquipo2.repository.ServicioRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendedorController {

    private VendedorRepository vendedorRepository;
    private ServicioRepository servicioRepository;

    public VendedorController(VendedorRepository vendedorRepository, ServicioRepository servicioRepository) {
        this.vendedorRepository = vendedorRepository;
        this.servicioRepository = servicioRepository;
    }

    /**
     * Buscar todos los vendedores en BBDD
     */

    @GetMapping("/api/vendedores")
    public List<Vendedor> findAll(){
        return vendedorRepository.findAll();
    }
}
