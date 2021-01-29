package m2i.fr.recettes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import m2i.fr.recettes.models.Categorie;
import m2i.fr.recettes.models.Recette;
import m2i.fr.recettes.services.CategorieService;
import m2i.fr.recettes.services.RecetteService;

@RestController
@RequestMapping("recettes")
public class RecetteController {
	
	@Autowired
	private RecetteService service;
	private CategorieService Cservice;
	
	@GetMapping()
	@ResponseStatus(code= HttpStatus.OK)
	public List<Recette> findAll(){
		return this.service.getAll();	
	}

	@GetMapping("/{id}")
	@ResponseStatus(code= HttpStatus.OK)
	public Recette findById(@PathVariable String id) {
		return this.service.findById(id);
	}

	@GetMapping("/nom/{nom}") 
	@ResponseStatus(code= HttpStatus.OK)
	public List<Recette> findByNom(@PathVariable String nom){
		return this.service.findByNom(nom);
	}
	
	@GetMapping("/Categorie/{nomCategorie}") 
	@ResponseStatus(code= HttpStatus.OK)
	public List<Recette> findByCategorie(@PathVariable String nomCategorie){
		Categorie categorie = this.Cservice.findByNom(nomCategorie);
		return this.service.findByCategorie(categorie);
	}

	@PostMapping()
	@ResponseStatus(code= HttpStatus.CREATED)
	public Recette save(@RequestBody Recette recette) {
		return this.service.save(recette);
	}

	@PutMapping("/{id}")
	@ResponseStatus(code= HttpStatus.ACCEPTED)
	public Recette update(@PathVariable String id, @RequestBody Recette recette) {
		Recette oldRecette = this.service.findById(id);
		recette.setId(oldRecette.getId());
		return this.service.update(recette);
	}
	

	@DeleteMapping("/{id}")
	@ResponseStatus(code= HttpStatus.ACCEPTED)
	public void delete(@PathVariable String id) {
		this.service.delete(id);
	}




}

