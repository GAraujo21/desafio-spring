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
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> listAll(){
        return clienteRepository.findAll();
    }
    /* Este modelo da maior controle na resposta HTTP do que o de cima...
    @GetMapping
    public ResponseEntity<List<Produto>> getProdutos() {
        return new ResponseEntity<List<Produto>>(produtoRepository.findAll(), HttpStatus.OK);   
    } */
    

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getCliente(@PathVariable Long id){
        Optional<Cliente> resp = clienteRepository.findById(id); // repete
        if(resp.isPresent()){
            return new ResponseEntity<Cliente>(resp.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } 
    /*Calabria
    @GetMapping ("/{id}")
    public Cliente buscar(@PathVariable Long id){
        Optional<cliente> resp = repository.findById(id);
        if (resp.isEmpty()) {
            return null;
        } else {
            return resp.get();
        }
    } */

    /* GERSON
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cliente findById(@PathVariable Long id) throws Exception{
        return clienteRepository.findById(id).orElseThrow();
    } */

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    /* OUTRA MANEIRA mais especifica na resposta HTTP.
     @PostMapping
    public ResponseEntity<Produto> addProduto(@RequestBody Produto produto) {
        produtoRepository.save(produto);
        return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
    } */

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody Cliente cliente){
        Optional<Cliente> respOptional = clienteRepository.findById(id); // repete
        if (respOptional.isEmpty()){
            return ResponseEntity.notFound().build(); // build funciona?
        }else{
            Cliente clienteExistente = respOptional.get();
            clienteExistente.setName(cliente.getName());
            clienteExistente.setAge(cliente.getAge());
            clienteExistente.setMarital_status(cliente.getMarital_status());
            clienteExistente.setDependents(cliente.getDependents());
            clienteExistente.setIncome(cliente.getIncome());
            //clienteExistente.setHouses(cliente.getHouses());
            //clienteExistente.setVehicles(cliente.getVehicles());
            
            Cliente clienteAtualizado = clienteRepository.save(clienteExistente);
            return ResponseEntity.ok(clienteAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id){
        Optional<Cliente> respOptional = clienteRepository.findById(id);  // repete
        if(respOptional.isEmpty()){
            return ResponseEntity.notFound().build(); //404 Not Found
        }else{
            Cliente clienteDeletar = respOptional.get();
            clienteRepository.delete(clienteDeletar);
            return ResponseEntity.ok().build();
        }
    }

    /* POSSIVELMENTE uma forma melhor.
    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> deleteClinete(@PathVariable Long id) {
        Optional<Cliente> respOptional = clienteRepository.findById(id);

        if (clienteRepository.isPresent()) {
            ClienteRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    */

}
