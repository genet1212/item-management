package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity(name = "Category")
@Table(name="categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name= "name")
    private String Name;

    @OneToMany(mappedBy = "category")
    private List<Item> items;

    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        this.Id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
}
