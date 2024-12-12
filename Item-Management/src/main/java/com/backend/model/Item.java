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
}
