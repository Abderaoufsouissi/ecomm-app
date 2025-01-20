package ars.org.billingservice.entity;

import ars.org.billingservice.dto.Product;
import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter @ToString
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


}
