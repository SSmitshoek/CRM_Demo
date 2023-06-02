package com.onclick.crmdemoproject.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "deals")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Min(value = 1, message = "Please make sure the title is at least 1 character long.")
    @Max(value = 30, message = "Please make sure the title is no more than 30 characters long.")
    private String title;

    private BigDecimal value;

    private String stage;

}