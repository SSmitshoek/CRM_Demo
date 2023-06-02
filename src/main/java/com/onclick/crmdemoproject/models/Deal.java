package com.onclick.crmdemoproject.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "deals")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Please make sure the title is filled in.")
    @Size(max = 30, message = "Please make sure the title is no more than 30 characters long.")
    private String title;

    @NotNull(message = "Please make sure the value is filled in.")
    private BigDecimal value;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Please make sure the stage is filled in.")
    private DealStageEnum stage;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    @JsonIgnore
    private Contact contact;

}