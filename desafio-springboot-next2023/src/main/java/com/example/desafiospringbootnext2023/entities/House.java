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
@Table(name = "house")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id", nullable = false)
    private Long id;

    @Column(name = "house_ownership_status", nullable = false)
    private String ownership_status;

    @Column(name = "house_locations", nullable = false)
    private String locations;
    
    @Column(name = "house_zipcode", nullable = false)
    private String zipcode;

    @ManyToOne
    @JoinColumn(name="cliente_id", nullable = false)
    //@JsonBackReference
    private Cliente cliente;


}

