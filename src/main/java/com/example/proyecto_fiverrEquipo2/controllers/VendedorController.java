package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.entities.Vendedor;
import com.example.proyecto_fiverrEquipo2.repository.PaquetesRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class VendedorController {

    private VendedorRepository vendedorRepository;
    private PaquetesRepository paquetesRepository;

    /**
     * Buscar todos los vendedores en BBDD
     */

    @GetMapping("/api/vendedores")
    public List<Vendedor> findAll(){
        return vendedorRepository.findAll();
    }
}
