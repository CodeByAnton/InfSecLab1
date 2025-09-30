package com.annton.lab1.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String model;

    @Column(nullable=false)
    private Integer power;

    @Column(nullable=false)
    private Integer price;
}
