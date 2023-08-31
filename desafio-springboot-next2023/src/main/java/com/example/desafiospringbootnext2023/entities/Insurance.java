package com.example.desafiospringbootnext2023.entities;
import java.util.Date;

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
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "insurance_id", nullable = false)
    private Long id;

    @Column(name = "insurance_type", nullable = false)
    private String type;

    @Column(name = "insurance_risk", nullable = false)
    private int risk;

    @Column(name = "insurance_analysis", nullable = false)
    private String analysis;

    @Column(name = "insurance_observation", nullable = true)
    private String observation;

    @Column(name = "insurance_created_at", nullable = false)
    private Date createdAt;
    
    @Column(name = "insurance_validate_at", nullable = false)
    private Date validateAt;

    @ManyToOne
    @JoinColumn(name="cliente_id", nullable = false)
    //@JsonBackReference
    private Cliente cliente;
}

