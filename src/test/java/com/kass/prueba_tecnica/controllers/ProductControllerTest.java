package com.kass.prueba_tecnica.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kass.prueba_tecnica.models.Product;
import com.kass.prueba_tecnica.services.interfaces.IProductService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser
    void testGetProducts() throws Exception {
        productService.save(new Product(1, "Product 1", "Laptop HP", 1200.0, 10));
        mockMvc.perform(get("/api/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser
    void testGetProductById() throws Exception {
        Product product = new Product(1, "Product 1", "Laptop HP", 1200.0, 10);
        Mockito.when(productService.findById(1)).thenReturn(product);

        mockMvc.perform(get("/api/products/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Product 1"));
    }

    @Test
    @WithMockUser
    void testCreateProduct() throws Exception {
        Product product = new Product(1, "Mouse", "Mouse inalámbrico", 25.0, 100);
        Mockito.when(productService.save(Mockito.any(Product.class))).thenReturn(product);

        mockMvc.perform(post("/api/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(product)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mouse"));
    }

    @Test
    @WithMockUser
    void testDeleteProduct() throws Exception {
        Mockito.doNothing().when(productService).deleteById(1);

        mockMvc.perform(delete("/api/products/1"))
                .andExpect(status().isOk());
    }
}
