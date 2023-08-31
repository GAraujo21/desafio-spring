package com.example.desafiospringbootnext2023.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.example.desafiospringbootnext2023.entities.House;

//@Repository
public interface HouseRepository extends JpaRepository<House, Long>{
   List<House> findByZipCode(String zipcode);
}
