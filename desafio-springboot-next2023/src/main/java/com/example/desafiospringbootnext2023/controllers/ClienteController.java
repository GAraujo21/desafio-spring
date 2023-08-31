package com.example.desafiospringbootnext2023.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiospringbootnext2023.DTO.ClienteDTO;
import com.example.desafiospringbootnext2023.entities.Cliente;
import com.example.desafiospringbootnext2023.service.ClienteService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ClienteController {

    //public ClienteRepository clienteRepository; //tiramos a responsabilidade de fazer direto ao repositorio
    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> listAll() {
        List<Cliente> listCliente = clienteService.listAll();
        return new ResponseEntity<>(listCliente, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id){
        Cliente cliente = this.clienteService.getById(id);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
    
    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = clienteService.create(clienteDTO);
        return new ResponseEntity<>(cliente, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @Valid ClienteDTO clienteDTO){
        Cliente cliente = clienteService.update(id, clienteDTO);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteCliente(@PathVariable Long id){ //Qual a diferença p/ ResponseEntity<?>
        if (clienteService.delete(id)) {
            return new ResponseEntity<>( HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /* 
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente){
        Optional<Cliente> respOptional = clienteRepository.findById(id);
        if (respOptional.isPresent()){
            Cliente clienteExistente = respOptional.get();
            clienteExistente.setName(cliente.getName());
            clienteExistente.setAge(cliente.getAge());
            clienteExistente.setMarital_status(cliente.getMarital_status());
            clienteExistente.setDependents(cliente.getDependents());
            clienteExistente.setIncome(cliente.getIncome());
            
            clienteRepository.save(clienteExistente);
            return new ResponseEntity<>(clienteExistente, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteClinete(@PathVariable Long id) {
        Optional<Cliente> respOptional = clienteRepository.findById(id);
        if (respOptional.isPresent()) {
            clienteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

}
