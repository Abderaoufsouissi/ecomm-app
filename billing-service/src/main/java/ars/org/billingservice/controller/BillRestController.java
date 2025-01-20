package ars.org.billingservice.controller;


import ars.org.billingservice.entity.Bill;
import ars.org.billingservice.entity.ProductItem;
import ars.org.billingservice.feign.CustomerRestClient;
import ars.org.billingservice.feign.ProductRestClient;
import ars.org.billingservice.repository.BillRepository;
import ars.org.billingservice.repository.ProductItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class BillRestController {
    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final CustomerRestClient customerRestClient;
    private final ProductRestClient productRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill = billRepository.findById(id).get();
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(
                productItem -> productItem.setProduct(productRestClient.getProductById(productItem.getProductId()))
        );

        return bill;
        }

    }

