package ars.org.billingservice.repository;

import ars.org.billingservice.entity.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}
