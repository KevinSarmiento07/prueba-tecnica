package com.kass.prueba_tecnica.services;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.kass.prueba_tecnica.dao.ProductDao;
import com.kass.prueba_tecnica.models.Product;
import com.kass.prueba_tecnica.services.implementation.ProductService;
import com.kass.prueba_tecnica.services.interfaces.IProductService;
import com.kass.prueba_tecnica.util.filters.ProductSpecification;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductDao productRepository;

    @InjectMocks
    private ProductService productService;

    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1, "Product 1", "Laptop HP", 100.0, 10);
    }

    @Test
    void testSaveProduct() {
        when(productRepository.save(any(Product.class))).thenReturn(product);
        Product savedProduct = productService.save(product);
        assertNotNull(savedProduct);
        assertEquals("Product 1", savedProduct.getName());
    }

    @Test
    void testFindById() {
        Product product = new Product(1, "Product 1", "Laptop HP", 100.0, 10);
        when(productRepository.findById(1)).thenReturn(Optional.of(product));

        Product result = productService.findById(1);

        assertNotNull(result);
        assertEquals("Product 1", result.getName());
        assertEquals(100.0, result.getPrice());
    }

    @Test
    void testDeleteProduct() {
        doNothing().when(productRepository).deleteById(1);
        assertDoesNotThrow(() -> productService.deleteById(1));
    }

    @Test
    void testFindAllProducts() {
        List<Product> products = List.of(product);
        Page<Product> productPage = new PageImpl<>(products);
        when(productRepository.findAll(any(Specification.class), any(Pageable.class))).thenReturn(productPage);

        Page<Product> result = productService.findAll(null, null, null, Pageable.unpaged());

        assertNotNull(result);
        assertEquals(1, result.getTotalElements());
    }
}
