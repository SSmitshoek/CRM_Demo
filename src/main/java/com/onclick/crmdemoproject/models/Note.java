package com.onclick.crmdemoproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please make sure the title is filled in.")
    @Size(max = 100, message = "Please make sure the title is no more than 100 characters long.")
    private String content;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;

    // getters and setters...
}
