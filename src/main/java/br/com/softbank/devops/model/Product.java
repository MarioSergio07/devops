package br.com.softbank.devops.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
public class Product implements Comparable <Product>{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private Long id;
    private String name;
    private String category;
    private String description;
    private String company;
    private String imagePath;
    private BigDecimal value;

    @Override
    public int compareTo(Product other) {
        return this.name.compareTo(other.getName());
    }
}
