package m2i.fr.recettes.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import m2i.fr.recettes.models.Recette;
import m2i.fr.recettes.models.Categorie;

public interface RecetteRepository extends MongoRepository <Recette, String>{

	public List<Recette> findByNom(String nom);
	public List<Recette> findByCategorie(Categorie Categorie);

}
