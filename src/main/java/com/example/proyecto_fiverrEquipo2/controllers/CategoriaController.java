package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.entities.Categoria;
import com.example.proyecto_fiverrEquipo2.repository.CategoriaRepository;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
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
public class CategoriaController {

    private final Logger log = LoggerFactory.getLogger(CategoriaController.class);

    private CategoriaRepository categoriaRepository;
    private TrabajoRepository trabajoRepository;

    public CategoriaController(CategoriaRepository categoriaRepository, TrabajoRepository trabajoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.trabajoRepository = trabajoRepository;
    }


    /**
     * Buscar todas las categorías en BBDD
     */
    @CrossOrigin
    @GetMapping("/api/categorias")
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    /**
     * Buscar categorías por  id
     * Request
     * Response
     */
    @CrossOrigin
    @GetMapping("/api/categorias/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);
        if (categoriaOpt.isPresent()) {
            return ResponseEntity.ok(categoriaOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
