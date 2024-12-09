package com.backend.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity(name="Employee")
@Table(name="employees")
@Getter
@Setter
@ToString
public class Employee {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

    @Column(name="first_name")
    private String firstName;
    @Column(name= "last_name")
    private String lastName;
    @Column(name= "email_id")
    private String emailId;
}
