package com.example.proyecto_fiverrEquipo2.service;



import com.example.proyecto_fiverrEquipo2.Dto.UserDto;
import com.example.proyecto_fiverrEquipo2.entities.User;

import java.util.List;

public interface UserService {
    User save(UserDto user);
    List<User> findAll();
    User findOne(String username);
}
