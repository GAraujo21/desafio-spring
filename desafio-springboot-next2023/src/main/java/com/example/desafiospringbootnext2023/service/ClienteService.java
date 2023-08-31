package com.example.desafiospringbootnext2023.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafiospringbootnext2023.DTO.ClienteDTO;
import com.example.desafiospringbootnext2023.entities.Cliente;
import com.example.desafiospringbootnext2023.repository.ClienteRepository;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteService {
    
    private final ClienteRepository clienteRepository;

    public Cliente create(ClienteDTO clienteDTO){
        Cliente cliente = clienteDTO.toEntity();
        cliente.setCreatedAt(LocalDate.now());
        cliente.setValidateAt(LocalDate.now());
        return this.clienteRepository.save(cliente);
    }

    public List<Cliente> listAll(){
        //return List<Cliente> listCliente = clienteRepository.findAll();// pq não funciona assim?
        List<Cliente> listCliente = clienteRepository.findAll();
        return listCliente.stream()
                .collect(Collectors.toList());
    }

    public Cliente getById(long id) {
        return this.clienteRepository.findById(id).orElse(null);
    }

    public Cliente update(long id, @Valid ClienteDTO clienteDTO) {
        Cliente cliente = this.clienteRepository.findById(id).orElse(null);
        if (cliente != null){
            Cliente updateCliente = clienteDTO.toEntityUpdate(cliente);
            return this.clienteRepository.save(updateCliente);
        }
        return null;
    }

    public boolean delete(long id) {
        Cliente cliente = this.clienteRepository.findById(id).orElse(null);
        if (cliente != null){
            this.clienteRepository.delete(cliente);
            return true;
        }
        return false;
    }
}
