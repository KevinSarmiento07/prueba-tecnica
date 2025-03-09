package com.kass.prueba_tecnica.services.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.kass.prueba_tecnica.models.Product;

public interface IProductService {

    public Page<Product> findAll(String name, Double minPrice, Double maxPrice, Pageable pageable);

    public Product findById(Integer id);

    public Product save(Product product);

    public void deleteById(Integer id);

    public Product update(Product product);

}
