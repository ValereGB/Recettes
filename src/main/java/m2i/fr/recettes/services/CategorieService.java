package m2i.fr.recettes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import m2i.fr.recettes.models.Recette;
import m2i.fr.recettes.models.Categorie;
import m2i.fr.recettes.repositories.CategorieRepository;

public class CategorieService {
	
	@Autowired private CategorieRepository repository;

	public Categorie findByNom(String nom){
		return this.repository.findByNom(nom);
	}

}
