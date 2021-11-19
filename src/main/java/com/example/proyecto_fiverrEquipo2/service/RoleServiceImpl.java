package com.example.proyecto_fiverrEquipo2.service;

import com.example.proyecto_fiverrEquipo2.entities.Role;
import com.example.proyecto_fiverrEquipo2.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}
