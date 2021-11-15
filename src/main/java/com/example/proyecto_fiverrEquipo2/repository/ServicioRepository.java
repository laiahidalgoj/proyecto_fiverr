package com.example.proyecto_fiverrEquipo2.repository;

import com.example.proyecto_fiverrEquipo2.entities.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
}
