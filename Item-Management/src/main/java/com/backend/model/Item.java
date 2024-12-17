package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="Item")
@Table(name="items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name")
    private String Name;
    @Column(name= "price")
    private String Price;
    @Column(name = "quantity")
    private String Quantity;
    @Column(name = "description")
    private String Description;

    @ManyToOne
    @JoinColumn(insertable=true, updatable = true, nullable = false)
    private Category category;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        this.Name = name;
    }
    public String getPrice() {
        return Price;
    }
    public  void  setPrice(String price) {
        this.Price = price;
    }
    public String getQuantity() {
        return Quantity;
    }
    public void  setQuantity(String quantity) {
        this.Quantity = quantity;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        this.Description = description;
    }
}