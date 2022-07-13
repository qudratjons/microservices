package com.jonson.inventoryservice;

import com.jonson.inventoryservice.model.Inventory;
import com.jonson.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

//    @Bean
    public CommandLineRunner saveData(InventoryRepository inventoryRepository) {
        return args -> {
            inventoryRepository.save(new Inventory(null, "123", 5));
        };
    }

}
