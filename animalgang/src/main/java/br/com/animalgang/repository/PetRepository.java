package br.com.animalgang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.animalgang.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
