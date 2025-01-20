package ars.org.billingservice;



import ars.org.billingservice.dto.Customer;
import ars.org.billingservice.dto.Product;
import ars.org.billingservice.entity.Bill;
import ars.org.billingservice.entity.ProductItem;
import ars.org.billingservice.feign.CustomerRestClient;
import ars.org.billingservice.feign.ProductRestClient;
import ars.org.billingservice.repository.BillRepository;
import ars.org.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;


@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);


    }


    @Bean
    CommandLineRunner commandLineRunner(
            BillRepository billRepository,
            ProductItemRepository productItemRepository,
            CustomerRestClient customerRestClient,
            ProductRestClient productRestClient
    ) {
        return args -> {

            Collection<Customer> customers =customerRestClient.getAllCustomers().getContent();
            Collection<Product> products =productRestClient.getAllProducts().getContent();
            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .customerId(customer.getId())
                        .build();
                billRepository.save(bill);

                products.forEach(product -> {
                    ProductItem productItem = ProductItem
                            .builder()
                            .productId(product.getId())
                            .bill(bill)
                            .quantity(new Random().nextInt(10)+1)
                            .unitPrice(product.getPrice())
                            .build();
                    productItemRepository.save(productItem);
                });
            });



        };
    }




}
