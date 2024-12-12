package com.backend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name="Employee")
@Table(name="employees")
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
    @Column(name = "user_name")
    private String userName;
}
