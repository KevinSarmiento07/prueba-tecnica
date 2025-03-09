package com.kass.prueba_tecnica.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.kass.prueba_tecnica.models.Product;

public interface ProductDao extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

}
