package m2i.fr.recettes.repositories;

import java.util.List;

import m2i.fr.recettes.models.Categorie;

public interface CategorieRepository {

	Categorie findByNom(String nom);




}
