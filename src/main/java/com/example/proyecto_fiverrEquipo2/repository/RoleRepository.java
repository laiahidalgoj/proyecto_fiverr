package com.example.proyecto_fiverrEquipo2.repository;


import com.example.proyecto_fiverrEquipo2.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findRoleByName(String name);
}