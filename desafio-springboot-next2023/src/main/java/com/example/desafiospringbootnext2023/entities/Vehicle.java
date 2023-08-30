package com.example.desafiospringbootnext2023.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vehicle_id", nullable = false)
    private Long id;
    @Column(name = "vehicle_brand", nullable = false)
    private String brand;
    @Column(name = "vehicle_model", nullable = false)
    private String model;
    @Column(name = "vehicle_year", nullable = false)
    private int year;

    @ManyToOne
    @JoinColumn(name="cliente_id", nullable = false)
    private Cliente cliente;
}
