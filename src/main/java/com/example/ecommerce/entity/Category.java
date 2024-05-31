package com.example.ecommerce.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "category", schema = "ecommerce")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String title;
    private Double rating;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category",fetch = FetchType.EAGER)
    @JsonIgnoreProperties("category")
    private List<Product> productList;

}
