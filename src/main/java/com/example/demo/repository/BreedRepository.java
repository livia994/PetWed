package com.example.demo.repository;

import com.example.demo.entity.Breed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BreedRepository extends CrudRepository<Breed, Integer> {
    @Query("SELECT b FROM Breed b WHERE b.breed= :breed")
    Breed getByName(String breed);
    @Query("SELECT b FROM Breed b WHERE b.species= :species")
    List<Breed> getBySpecies(String species);
}
