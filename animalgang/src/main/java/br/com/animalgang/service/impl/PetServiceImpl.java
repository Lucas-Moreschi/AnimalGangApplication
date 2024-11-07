package br.com.animalgang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.animalgang.dto.PetDto;
import br.com.animalgang.entity.Pet;
import br.com.animalgang.repository.PetRepository;
import br.com.animalgang.service.PetService;

@Service
public class PetServiceImpl implements PetService{

	@Autowired
    private PetRepository petRepository;
	
	@Override
	public List<Pet> listarPets() {
		return petRepository.findAll();
	}

	@Override
	public void deleteById(Long id) {
		petRepository.deleteById(id);
		
	}

	@Override
	public Pet editarPet(Long id) {
		return petRepository.findById(id).get();
		
	}
	
	@Override
	public Pet updatePet(Pet pet) {
        return petRepository.save(pet);
    }

	@Override
	public void adicionarPet(PetDto petDto) {
	    Pet pet = new Pet();
	    pet.setNome(petDto.getNome());
	    pet.setSexo(petDto.getSexo());
	    pet.setIdade(petDto.getIdade());
	    pet.setTipo(petDto.getTipo());
	    pet.setDescricao(petDto.getDescricao());
	    pet.setImagemURL(petDto.getImagemUrl());
	    petRepository.save(pet);
	}
	
	

}
