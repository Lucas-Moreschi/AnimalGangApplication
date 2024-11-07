package br.com.animalgang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.animalgang.dto.PetDto;
import br.com.animalgang.entity.Pet;
import br.com.animalgang.service.PetService;


@Controller
public class IndexController {

	@Autowired
    private PetService petService;
	
	@GetMapping ("/")
	public String listarPets(Model model) {
		List<Pet> pets = petService.listarPets();
		model.addAttribute("pets", pets);
		return "index";
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
	}
	
	
	@GetMapping("/editar-pets")
	public String editarPetsPage(Model model) {
		List<Pet> pets = petService.listarPets();
        model.addAttribute("pets", pets);
        return "editarPets";
    }
	
    @PostMapping("/adicionar-pets")
    public String adicionarPets(@ModelAttribute PetDto petDto) {
        petService.adicionarPet(petDto);
        return "redirect:/editar-pets";
    }
	
	@GetMapping("/excluir/{id}")
	public String excluirTarefa(Model model, @PathVariable Long id) {
		petService.deleteById(id);
		return "redirect:/editar-pets";
	}

	@GetMapping("/editar/{id}")
	public String editarTarefa(Model model, @PathVariable Long id) {
		Pet pet = petService.editarPet(id);
		model.addAttribute("pet", pet);
		return "editar-pet";
	}
	
	@PostMapping("atualizar-pet/{id}")
    public String updatePet(@PathVariable("id") Long id, @ModelAttribute Pet pet, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("pet", pet);
            return "editar-pet";
        }

        pet.setId(id);
        petService.updatePet(pet);
        return "redirect:/editar-pets";
    }
	
	 @GetMapping("/sobre")
	    public String sobre() {
	        return "sobre";
	}
	
}
