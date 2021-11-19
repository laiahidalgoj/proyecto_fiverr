package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.Dto.TrabajoDto;
import com.example.proyecto_fiverrEquipo2.entities.Categoria;
import com.example.proyecto_fiverrEquipo2.entities.Review;
import com.example.proyecto_fiverrEquipo2.entities.Trabajo;
import com.example.proyecto_fiverrEquipo2.repository.CategoriaRepository;
import com.example.proyecto_fiverrEquipo2.repository.ReviewRepository;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class CategoriaController {

    private final Logger log = LoggerFactory.getLogger(CategoriaController.class);

    private CategoriaRepository categoriaRepository;
    private TrabajoRepository trabajoRepository;
    private ReviewRepository reviewRepository;

    public CategoriaController(CategoriaRepository categoriaRepository, TrabajoRepository trabajoRepository, ReviewRepository reviewRepository) {
        this.categoriaRepository = categoriaRepository;
        this.trabajoRepository = trabajoRepository;
        this.reviewRepository = reviewRepository;
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
     *
     * @return
     */
    @CrossOrigin
    @GetMapping("/api/categorias/{id}")
    public List<TrabajoDto> findById(@PathVariable Long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);

        if (categoriaOpt.isPresent()) {
            Set<Trabajo> trabajos1 = categoriaOpt.get().getTrabajos();
            for(Trabajo trabajo : trabajos1) {
                log.info(String.valueOf(trabajo));
            }
            List<TrabajoDto> trabDtos = new ArrayList<>();

            for(Trabajo trabajo : trabajos1) {
                TrabajoDto trabajoDto = new TrabajoDto(trabajo.getId(), trabajo.getNombre(), trabajo.getImagen(),
                        trabajo.getDescripcion(), trabajo.getPrecio(), trabajo.getCategorias(), trabajo.getVendedores(),
                        trabajo.getFecha_Publicacion(), trabajo.getPaises(), trabajo.getIdiomas());
                trabDtos.add(trabajoDto);
                }

                return trabDtos;
            }

        return null;
    }


    /**
     * Crear categoria nueva en la bbdd.
     *
     * @param categoria
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
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
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
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

    /**
     * Eliminar una categoría de la BBDD.
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @DeleteMapping("/api/categorias/{id}")
    public ResponseEntity<Categoria> delete(@PathVariable Long id) {

        if (!categoriaRepository.existsById(id)) {
            log.warn("Intentando eliminar una categoría inexistente");
            return ResponseEntity.notFound().build();
        }

        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);
        if (categoriaOpt.isPresent()) {
            Categoria categoria = categoriaOpt.get();
            Set<Trabajo> trabajos = categoria.getTrabajos();
            for (Trabajo trabajo : trabajos) {
                trabajo.removeCategoria(categoria, false);
                trabajoRepository.save(trabajo);
            }
        }

        categoriaRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todas las categorias de la base de datos
     *
     * @return
     */
    @CrossOrigin
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/api/categorias")
    public ResponseEntity<Categoria> deleteAll() {
        List<Categoria> categorias = categoriaRepository.findAll();

        for (Categoria categoria : categorias) {
            Set<Trabajo> trabajos = categoria.getTrabajos();
            for (Trabajo trabajo : trabajos) {
                trabajo.removeCategoria(categoria, false);
                trabajoRepository.save(trabajo);
            }
        }
        categoriaRepository.deleteAll();

        return ResponseEntity.noContent().build();
    }
}