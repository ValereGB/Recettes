package m2i.fr.recettes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import m2i.fr.recettes.models.Recette;
import m2i.fr.recettes.models.Categorie;
import m2i.fr.recettes.repositories.RecetteRepository;

@Service
public class RecetteService {
	
	@Autowired
	private RecetteRepository repository;

	public List<Recette> getAll() {
		return this.repository.findAll();
	}
	
	public Recette findById(String id) {
		return this.repository.findById(id)
				//sinon on demande de lancer
				.orElseThrow(
						//une fonction lambda / closure qui renvoie une exception HTTP 
						()->new ResponseStatusException(HttpStatus.NOT_FOUND)
						);
	}
	
	public List<Recette> findByNom(String nom){
		return this.repository.findByNom(nom);
	}
	
	public Recette save(Recette recette) {
		return this.repository.insert(recette);
	}

	public Recette update(Recette recette) {
		return this.repository.save(recette);
	}

	public List<Recette> findByCategorie(Categorie Categorie) {
		return this.repository.findByCategorie(Categorie);
	}

	public void delete(String id) {
		this.repository.deleteById(id);
		
	}
	
}
