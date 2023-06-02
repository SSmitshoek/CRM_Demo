package com.onclick.crmdemoproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "contacts")
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "Please make sure the first name is at least 1 character long.")
    @Max(value = 20, message = "Please make sure the first name is no more than 20 characters long.")
    private String firstName;

    @Min(value = 1, message = "Please make sure the last name is at least 1 character long.")
    @Max(value = 30, message = "Please make sure the last name is no more than 20 characters long.")
    private String lastName;

    @Email(message = "Please enter a valid email address.")
    private String email;

    private String phone;

    @OneToMany
    private List<Deal> deals;

    // getters and setters...
}