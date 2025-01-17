package ars.org.inventoryservice;

import ars.org.inventoryservice.entity.Product;
import ars.org.inventoryservice.repository.ProductRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.logging.Logger;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }



    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product(UUID.randomUUID().toString(),"Iphone12",1500.0,20));
            productRepository.save(new Product(UUID.randomUUID().toString(),"HP15",700.0,35));
            productRepository.save(new Product(UUID.randomUUID().toString(),"EliteBook",3500.0,22));
            productRepository.findAll().forEach(System.out::println);
        };




    }

}
