package com.example.desafiospringbootnext2023.DTO;

import java.time.LocalDate;

import com.example.desafiospringbootnext2023.entities.Cliente;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @NotBlank
    @Size(min = 0)
    private int age;

    @NotBlank
    @Size(min = 0)
    private int dependents;

    @NotBlank
    @Size(min = 0)
    private double income;

    @NotBlank
    private String marital_status;
    
    public Cliente toEntity(){
        return Cliente.builder()
                .name(this.name)
                .age(this.age)
                .dependents(this.dependents)
                .income(this.income)
                .marital_status(this.marital_status)
                .createdAt(LocalDate.now())
                .validateAt(LocalDate.now())
                .build();
    }

    public Cliente toEntityUpdate(Cliente cliente){
        return Cliente.builder()
                .id(cliente.getId())
                .name(this.name)
                .age(this.age)
                .dependents(this.dependents)
                .income(this.income)
                .marital_status(this.marital_status)
                .houses(cliente.getHouses())
                .vehicles(cliente.getVehicles())
                .createdAt(cliente.getCreatedAt())
                .validateAt(LocalDate.now())
                .build();
    }

}
