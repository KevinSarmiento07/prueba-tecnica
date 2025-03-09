package com.kass.prueba_tecnica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kass.prueba_tecnica.models.Role;

public interface RoleDao extends JpaRepository<Role, Integer> {
    
    Role findByRole(String role);

}
