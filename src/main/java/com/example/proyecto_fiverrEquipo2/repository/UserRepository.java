package com.example.proyecto_fiverrEquipo2.repository;


import com.example.proyecto_fiverrEquipo2.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByEmail(String email);
}