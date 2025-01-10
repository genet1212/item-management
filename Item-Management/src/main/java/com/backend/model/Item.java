package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Data
@Entity(name="Item")
@Table(name="items")
public class Item implements Serializable {

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id) && Objects.equals(Name, item.Name) && Objects.equals(Price, item.Price) && Objects.equals(Quantity, item.Quantity) && Objects.equals(Description, item.Description) && Objects.equals(category, item.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Name, Price, Quantity, Description, category);
    }
}
