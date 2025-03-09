package com.kass.prueba_tecnica;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class PruebaTecnicaApplicationTests {

	@Autowired
    private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}

	/* @Test
    public void testGetAllProducts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/products")
        .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    } */

}
