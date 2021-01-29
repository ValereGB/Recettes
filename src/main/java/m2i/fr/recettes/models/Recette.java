package m2i.fr.recettes.models;

import java.util.List;

import lombok.Data;


@Data
public class Recette {
	
	
	private String id;
	
	private String nom;
	private String description;
	
	private List<Ingredient> Ingredients;
	private List<Categorie> Categories;
	

}
