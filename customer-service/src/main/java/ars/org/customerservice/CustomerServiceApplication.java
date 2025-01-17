package ars.org.customerservice;

import ars.org.customerservice.entity.Customer;
import ars.org.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
public class CustomerServiceApplication {
	Logger log = Logger.getLogger(CustomerServiceApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}



	@Bean
	CommandLineRunner run(CustomerRepository customerRepository) {

		return args -> {
			customerRepository.save(new Customer("Mohamed","Souissi","mohamed.souissi@gmail.com"));
			customerRepository.save(new Customer("Abderaouf","Souissi","abderaouf.souissi@gmail.com"));
			customerRepository.save(new Customer("Abdelmonem","Souissi","abdelmonem.souissi@gmail.com"));


			customerRepository.findAll().forEach(customer -> log.info(customer.toString()));

		};
	}






}
