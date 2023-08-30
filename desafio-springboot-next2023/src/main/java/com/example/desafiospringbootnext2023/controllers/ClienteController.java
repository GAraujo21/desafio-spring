package com.example.desafiospringbootnext2023.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiospringbootnext2023.entities.Cliente;
import com.example.desafiospringbootnext2023.repository.ClienteRepository;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    public ClienteRepository clienteRepository;

    @GetMapping
    public ResponseEntity<List<Cliente>> getProdutos() {
        return new ResponseEntity<List<Cliente>>(clienteRepository.findAll(), HttpStatus.OK);   
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id){
        Optional<Cliente> resp = clienteRepository.findById(id);
        if(resp.isPresent()){
            return new ResponseEntity<Cliente>(resp.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 

     @PostMapping
    public ResponseEntity<Cliente> addProduto(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return new ResponseEntity<Cliente>(cliente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
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
    }

}
