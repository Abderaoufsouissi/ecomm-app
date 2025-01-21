package ars.org.customerservice;

import ars.org.customerservice.config.CustomerConfigParams;
import ars.org.customerservice.entity.Customer;
import ars.org.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.logging.Logger;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {
	private static final Logger log = Logger.getLogger(CustomerServiceApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}



	@Bean
	CommandLineRunner run(CustomerRepository customerRepository) {

		return args -> {
			customerRepository.save(Customer.builder().firstName("Mohamed").lastName("Souissi").email("mohamed.souissi@gmail.com").build());
			customerRepository.save(Customer.builder().firstName("Abderaouf").lastName("Souissi").email("abderaouf.souissi@gmail.com").build());
			customerRepository.save(Customer.builder().firstName("Abdelmonem").lastName("Souissi").email("abdelmonem.souissi@gmail.com").build());
			customerRepository.findAll().forEach(customer -> log.info(customer.toString()));

		};
	}






}
