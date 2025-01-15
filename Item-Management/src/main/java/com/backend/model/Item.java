package com.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore; // Optional annotation
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Data
@Entity(name = "Item")
@Table(name = "items")
public class  Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Use camelCase

    @Column(name = "price")
    private Long price;

    @Column(nullable = false)
    private Long quantity;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})

    @JsonIgnore
    private Category category;

    // No need for redundant @Setter with @Data
}