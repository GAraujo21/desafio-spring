package com.example.desafiospringbootnext2023.entities;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_id", nullable = false)
    private Long id;
    @Column(name = "cliente_name", nullable = false)
    private String name;
    @Column(name = "cliente_age", nullable = false)
    private int age;
    @Column(name = "cliente_dependents", nullable = false)
    private int dependents;
    @Column(name = "cliente_income", nullable = false)
    private double income;
    @Column(name = "cliente_marital_status", nullable = false)
    private String marital_status;
    @Column(name = "cliente_created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "cliente_validade_at", nullable = false)
    private LocalDateTime validateAt;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "cliente")
    private List<Vehicle> vehicles;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "cliente")
    private List<House> houses;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, mappedBy = "cliente")
    private List<Insurance> insurances;
}