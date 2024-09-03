package com.example.product.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Size(min = 2, max = 50)
    @NotEmpty
    @NotNull
    private String name;

    @Column()
    @Max(value = 500)
    private String description;

    @Column()
    private BigDecimal price;

    @Column()
    private Long quantity;
}
