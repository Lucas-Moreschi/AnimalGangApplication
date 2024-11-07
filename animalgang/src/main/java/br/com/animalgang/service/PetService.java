package br.com.animalgang.service;

import java.util.List;

import br.com.animalgang.dto.PetDto;
import br.com.animalgang.entity.Pet;

public interface PetService {
	
	public List<Pet> listarPets();
	
	public void deleteById(Long id);
	
	public Pet editarPet(Long id);
	
	public void adicionarPet(PetDto pet);
	
	public Pet updatePet(Pet pet);
	
}
