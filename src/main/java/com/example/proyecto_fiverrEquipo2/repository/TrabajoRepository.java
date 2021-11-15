package com.example.proyecto_fiverrEquipo2.repository;

import com.example.proyecto_fiverrEquipo2.entities.Trabajos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajoRepository extends JpaRepository<Trabajos, Long> {
}
