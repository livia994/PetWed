package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import com.example.demo.entity.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {
    @Query("SELECT p  from  Pet p where p.breed.id= :breedId")
    List<Pet> getPetsByBreedId(Long breedId);
    @Query("SELECT p  from  Pet p where p.user.id= :userId ")
    List<Pet> getPetsByUserId(Long userId);

    @Query("SELECT p from Pet p")
    List<Pet> allPets();

    @Query("SELECT p FROM Pet p WHERE p.id= :petId")
    Pet getById(long petId);
//DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(), date_of_birth)), '%Y') + 0
    @Query("SELECT DATE_FORMAT(FROM_DAYS(DATEDIFF(NOW(),p.birthDate)), '%Y') FROM Pet p WHERE p.id= :petId")
    int getAge(Long petId);


}
