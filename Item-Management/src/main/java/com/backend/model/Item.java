package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

@Data
@Entity(name="Item")
@Table(name="items")
public class Item {

    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String Name;
    @Setter
    @Column(name = "price")
    private Long Price;
    @Setter
    @Column(nullable = false)
    private Long Quantity;
    @Setter
    @Column(nullable = false)
    private String Description;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")

    private Category category;
    public Category getCategory() {return category;}

    public Long getId() {return id;}

    public String getName() {return Name;}

    public Long getPrice() {return Price;}

    public Long getQuantity() {return Quantity;}

    public String getDescription() {return Description;}

    public void assignCategory(Category category) {
        this.category = category;
    }
}
