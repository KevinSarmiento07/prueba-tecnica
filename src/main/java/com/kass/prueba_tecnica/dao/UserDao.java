package com.kass.prueba_tecnica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kass.prueba_tecnica.models.User;

public interface UserDao extends JpaRepository<User, Integer> {
    
    User findByUsername(String username);

}
