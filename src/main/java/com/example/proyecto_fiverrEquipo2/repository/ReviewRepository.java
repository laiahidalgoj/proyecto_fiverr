package com.example.proyecto_fiverrEquipo2.repository;

import com.example.proyecto_fiverrEquipo2.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
