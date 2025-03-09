package com.kass.prueba_tecnica.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kass.prueba_tecnica.dao.ProductDao;
import com.kass.prueba_tecnica.models.Product;
import com.kass.prueba_tecnica.services.interfaces.IProductService;
import com.kass.prueba_tecnica.util.filters.ProductSpecification;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void deleteById(Integer id) {
        productDao.deleteById(id);        
    }

    @Override
    public Page<Product> findAll(String name, Double minPrice, Double maxPrice, Pageable pageable) {
        Specification<Product> spec = Specification.where(ProductSpecification.nameContains(name)).and(ProductSpecification.priceBetween(minPrice, maxPrice));
        return productDao.findAll(spec, pageable);
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public Product update(Product product) {
        return productDao.save(product);
    }



}
