package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.entities.Vendedor;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
import com.example.proyecto_fiverrEquipo2.repository.VendedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class VendedorController {

    private final Logger log = LoggerFactory.getLogger(VendedorController.class);

    private VendedorRepository vendedorRepository;
    private TrabajoRepository trabajoRepository;

    public VendedorController(VendedorRepository vendedorRepository, TrabajoRepository trabajoRepository) {
        this.vendedorRepository = vendedorRepository;
        this.trabajoRepository = trabajoRepository;
    }

    /**
     * Buscar todos los vendedores en BBDD
     */
    @CrossOrigin
    @GetMapping("/api/vendedores")
    public List<Vendedor> findAll() {
        return vendedorRepository.findAll();
    }

    /**
     * Buscar vendedor por  id
     * Request
     * Response
     */
    @CrossOrigin
    @GetMapping("/api/vendedor/{id}")
    public ResponseEntity<Vendedor> findById(@PathVariable Long id) {
        Optional<Vendedor> vendedorOpt = vendedorRepository.findById(id);
        if (vendedorOpt.isPresent()) {
            return ResponseEntity.ok(vendedorOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
