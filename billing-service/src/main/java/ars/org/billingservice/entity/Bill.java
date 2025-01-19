package ars.org.billingservice.entity;

import ars.org.billingservice.dto.Customer;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private Long customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems = new ArrayList<>();
    @Transient
    private Customer customer;



    protected Bill() {}


    public Bill(Date billingDate, Long customerId, List<ProductItem> productItems) {
        this.billingDate = billingDate;
        this.customerId = customerId;
        this.productItems = productItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(Date billingDate) {
        this.billingDate = billingDate;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<ProductItem> getProducts() {
        return productItems;
    }

    public void setProducts(List<ProductItem> products) {
        this.productItems = products;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", billingDate=" + billingDate +
                ", customerId=" + customerId +
                '}';
    }
}
