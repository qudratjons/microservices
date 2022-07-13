package com.jonson.productservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jonson.productservice.dto.ProductDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@SpringBootTest
//@Testcontainers
//@AutoConfigureMockMvc
class ProductServiceApplicationTests {

//    @Autowired
    private MockMvc mockMvc;

//    @Autowired
    private ObjectMapper objectMapper;

//    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.2.2");

//    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry properties) {
        properties.add("spring.data.mongo.uri", mongoDBContainer::getReplicaSetUrl);
    }

//    @Test
    void shouldCreateProductAndReturnProduct() throws Exception {

        ProductDTO productDTO = new ProductDTO()
                .setName("Monitor")
                .setDescription("Gaming monitor")
                .setPrice(BigDecimal.valueOf(1000));

        String requestBody = objectMapper.writeValueAsString(productDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/product/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)
        ).andExpect(status().isOk());

    }

}
