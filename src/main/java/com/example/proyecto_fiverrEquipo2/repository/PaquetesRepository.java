package com.example.proyecto_fiverrEquipo2.repository;

import com.example.proyecto_fiverrEquipo2.entities.Paquetes;
import com.example.proyecto_fiverrEquipo2.entities.Paquetes;
import com.example.proyecto_fiverrEquipo2.entities.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Repository
public interface PaquetesRepository extends JpaRepository<Paquetes, Long> {
}
