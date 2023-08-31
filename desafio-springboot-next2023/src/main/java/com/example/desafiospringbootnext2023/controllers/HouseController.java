package com.example.desafiospringbootnext2023.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafiospringbootnext2023.entities.House;
import com.example.desafiospringbootnext2023.repository.HouseRepository;

@RestController
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;
    

    @GetMapping("/{zipcode}")
    public ResponseEntity<List<House>> zipCode(@PathVariable String zipcode){
        List<House> houseList = houseRepository.findByZipCode(zipcode);
        return new ResponseEntity<>(houseList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<House> createHouse(@RequestBody House house){
        houseRepository.save(house);
        return new ResponseEntity<House>(house, HttpStatus.CREATED);
    }

    /*@PutMapping("/{id}")
    public ResponseEntity<House> updateHouse(@PathVariable Long id, @RequestBody House house){
        Optional<House> houseOptional = houseRepository.findById(id);
        if (houseOptional.isPresent()){
            House houseExist = houseOptional.get();
            houseExist.se
        }
    }*/
}
