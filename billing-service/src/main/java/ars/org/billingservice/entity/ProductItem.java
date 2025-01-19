package ars.org.billingservice.entity;

import ars.org.billingservice.dto.Product;
import jakarta.persistence.*;


@Entity
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private int quantity;
    private double unitPrice;
    @ManyToOne
    private Bill bill;
    @Transient
    private Product product;

    protected ProductItem() {}

    public ProductItem(String productId, int quantity, double unitPrice, Bill bill) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.bill = bill;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    @Override
    public String toString() {
        return "ProductItem{" +
                "id=" + id +
                ", productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", bill=" + bill +
                '}';
    }
}
