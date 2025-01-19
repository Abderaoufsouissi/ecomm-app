package ars.org.billingservice.feign;

import ars.org.billingservice.dto.Customer;
import ars.org.billingservice.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/products/{id}")
    Product findProductById(@PathVariable String id);

    @GetMapping("/products")
    PagedModel<Product> findAllProducts();
}
