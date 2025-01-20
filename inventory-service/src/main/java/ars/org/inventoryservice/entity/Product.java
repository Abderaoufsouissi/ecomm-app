package ars.org.inventoryservice.entity;



import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.*;


@AllArgsConstructor @NoArgsConstructor @Builder
@Getter @Setter @ToString
@Entity
public class Product {
    @Id
    private String id;
    private String name;
    private double price;
    private int quantity;

}
