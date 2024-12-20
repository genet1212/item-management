package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "Category")
@Table(name="categories")
public class Category {
    @Setter
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Setter
    @Getter
    @Column(name= "name")
    private String Name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)

    private List<Item> items = new ArrayList<Item>();

}
