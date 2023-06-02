package com.onclick.crmdemoproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "contacts")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please make sure the first name is filled in.")
    @Size(max = 20, message = "Please make sure the first name is no more than 20 characters long.")
    private String firstName;

    @NotNull(message = "Please make sure the last name is filled in.")
    @Size(max = 30, message = "Please make sure the last name is no more than 20 characters long.")
    private String lastName;

    @Email(message = "Please enter a valid email address.")
    private String email;

    private String phone;

    @OneToMany
    private List<Deal> deals;

    // getters and setters...
}