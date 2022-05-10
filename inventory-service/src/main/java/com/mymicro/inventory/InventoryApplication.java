package com.mymicro.inventory;

import com.mymicro.inventory.dataAccess.InventoryRepository;
import com.mymicro.inventory.entities.Inventory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class InventoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(InventoryApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
        return args -> {
            inventoryRepository.saveAll(
                    List.of(
                            new Inventory("iphone_13",100),
                            new Inventory("iphone_13_red",0)
                    ));
        };
    }
}
