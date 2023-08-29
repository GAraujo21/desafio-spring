package com.example.desafiospringbootnext2023.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private int dependents;
    private double income;
    private String marital_status;
    private Date createdAt;
    private Date validateAt;

    //como ficam os casos onde o cliente NÃO tem casa/veiculo/seguro?
    @OneToMany(mappedBy = "Client")
    private List<House> houses;
    @OneToMany(mappedBy = "Client")
    private List<Insurance> insurances;
    @OneToMany(mappedBy = "Client")
    private List<Vehicle> vehicles;
}
