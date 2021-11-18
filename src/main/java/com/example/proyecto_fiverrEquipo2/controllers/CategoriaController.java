package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.entities.Categoria;
import com.example.proyecto_fiverrEquipo2.entities.Trabajo;
import com.example.proyecto_fiverrEquipo2.repository.CategoriaRepository;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    /**
     * Crear categoria nueva en la bbdd.
     *
     * @param categoria
     * @return
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/api/categorias")
    public ResponseEntity<Categoria> create(@RequestBody Categoria categoria) {
        if (categoria.getId() != null) {
            log.warn("Intentando crear una categoría con id");
            return ResponseEntity.badRequest().build();
        }
        List<Categoria> categorias = categoriaRepository.findAll();
        for (Categoria categoriaExistente : categorias) {
            if (categoriaExistente.getNombre().equals(categoria.getNombre())) {
                log.warn("Intentando crear una categoría ya existente");
                return ResponseEntity.badRequest().build();
            }
        }

        Categoria result = categoriaRepository.save(categoria);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar una categoría en la bbdd.
     *
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PutMapping("/api/categorias")
    public ResponseEntity<Categoria> update(@RequestBody Categoria categoria) {
        if (categoria.getId() == null) {
            log.warn("Intentando actualizar una categoría sin añadir el id");
            return ResponseEntity.badRequest().build();
        }
        if (!categoriaRepository.existsById(categoria.getId())) {
            log.warn("Intentando actualizar una categoría con id inexistente");
            return ResponseEntity.notFound().build();
        }

        Categoria result = categoriaRepository.save(categoria);
        return ResponseEntity.ok(result);
    }

}
