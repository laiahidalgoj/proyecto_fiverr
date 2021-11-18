package com.example.proyecto_fiverrEquipo2.controllers;

import com.example.proyecto_fiverrEquipo2.entities.Review;
import com.example.proyecto_fiverrEquipo2.repository.CategoriaRepository;
import com.example.proyecto_fiverrEquipo2.repository.ReviewRepository;
import com.example.proyecto_fiverrEquipo2.repository.TrabajoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    private final Logger log = LoggerFactory.getLogger(ReviewController.class);

    private ReviewRepository reviewRepository;
    private TrabajoRepository trabajoRepository;
    private CategoriaRepository categoriaRepository;

    public ReviewController(ReviewRepository reviewRepository, TrabajoRepository trabajoRepository, CategoriaRepository categoriasRepository) {
        this.reviewRepository = reviewRepository;
        this.trabajoRepository = trabajoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    /**
     * Buscar todas las reviews en BBDD.
     */
    @CrossOrigin
    @GetMapping("/api/reviews")
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    /**
     * Buscar reviews por id
     * Request
     * Response
     */
    @CrossOrigin
    @GetMapping("/api/reviews/{id}")
    public ResponseEntity<Review> findById(@PathVariable Long id) {
        Optional<Review> reseñaOpt = reviewRepository.findById(id);
        if (reseñaOpt.isPresent()) {
            return ResponseEntity.ok(reseñaOpt.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear nueva review en la bbdd.
     *n
     */
    @CrossOrigin
//    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @PostMapping("/api/reviews")
    public ResponseEntity<Review> create(@RequestBody Review review) {
        if (review.getId() != null) {
            log.warn("Intentando crear una review con id");
            return ResponseEntity.badRequest().build();
        }

        Review result = reviewRepository.save(review);
        return ResponseEntity.ok(result);
    }



}
