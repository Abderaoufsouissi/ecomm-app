package ars.org.customerservice.repository;

import ars.org.customerservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;



@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
