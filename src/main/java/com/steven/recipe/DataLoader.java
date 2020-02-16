package com.steven.recipe;

import com.steven.recipe.domain.*;
import com.steven.recipe.repositories.CategoryRepository;
import com.steven.recipe.repositories.RecipeRepository;
import com.steven.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;

/**
 * stevmc created on 2/16/20
 */
@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {

	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;
	private final RecipeRepository recipeRepository;

	public DataLoader(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository,
			RecipeRepository recipeRepository) {
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
		this.recipeRepository = recipeRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		recipeRepository.saveAll(getRecipes());
	}

	public List<Recipe> getRecipes() {
		List<Recipe> recipes = new ArrayList<>(2);
		System.out.println("Loading Units of Measure.....");
		Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
		if (!tablespoon.isPresent()) {
			throw new RuntimeException("Expected Unit of Measure Not Found");
		}

		Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
		if (!teaspoon.isPresent()) {
			throw new RuntimeException("Expected Unit of Measure Not Found");
		}

		Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription("Cup");
		if (!cup.isPresent()) {
			throw new RuntimeException("Expected Unit of Measure Not Found");
		}

		Optional<UnitOfMeasure> pinch = unitOfMeasureRepository.findByDescription("Pinch");
		if (!pinch.isPresent()) {
			throw new RuntimeException("Expected Unit of Measure Not Found");
		}

		Optional<UnitOfMeasure> ounce = unitOfMeasureRepository.findByDescription("Ounce");
		if (!ounce.isPresent()) {
			throw new RuntimeException("Expected Unit of Measure Not Found");
		}

		Optional<UnitOfMeasure> dash = unitOfMeasureRepository.findByDescription("Dash");
		if (!dash.isPresent()) {
			throw new RuntimeException("Expected Unit of Measure Not Found");
		}

		Optional<UnitOfMeasure> whole = unitOfMeasureRepository.findByDescription("Whole");
		if (!whole.isPresent()) {
			throw new RuntimeException("Expected Unit of Measure Not Found");
		}
		System.out.println("Loaded Units of Measure.....");

		System.out.println("Get Optionals Unit of Measure.....");
		UnitOfMeasure tableSpoonUom = tablespoon.get();
		UnitOfMeasure teaSpoonUom = teaspoon.get();
		UnitOfMeasure cupUom = cup.get();
		UnitOfMeasure pinchUom = pinch.get();
		UnitOfMeasure ounceUom = ounce.get();
		UnitOfMeasure dashUom = dash.get();
		UnitOfMeasure wholeUom = whole.get();
		System.out.println("Got Optionals Unit of Measure.....");

		System.out.println("Loading Categories.....");
		Optional<Category> american = categoryRepository.findByDescription("American");
		if (!american.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}

		Optional<Category> italian = categoryRepository.findByDescription("Italian");
		if (!italian.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}

		Optional<Category> mexican = categoryRepository.findByDescription("Mexican");
		if (!mexican.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}

		Optional<Category> fastFood = categoryRepository.findByDescription("Fast Food");
		if (!fastFood.isPresent()) {
			throw new RuntimeException("Expected Category Not Found");
		}
		System.out.println("Loaded Categories.....");

		System.out.println("Get Optionals Categories.....");
		Category americanCat = american.get();
		Category italianCat = italian.get();
		Category mexicanCat = mexican.get();
		Category fastFoodCat = fastFood.get();
		System.out.println("Got Optionals Categories.....");

		System.out.println("Loading Guacomole recipe.....");
		Recipe guacRecipe = new Recipe();

		guacRecipe.getCategories().add(mexicanCat);
		guacRecipe.getCategories().add(americanCat);

		Set<Ingredient> ingredients = new HashSet<>();

		guacRecipe.addIngredient(new Ingredient(new BigDecimal(2), "ripe avocados", wholeUom));
		guacRecipe.addIngredient(new Ingredient(new BigDecimal(.25), "salt", teaSpoonUom));
		guacRecipe.addIngredient(new Ingredient(new BigDecimal(1), "lime juice", tableSpoonUom));
		guacRecipe.addIngredient(new Ingredient(new BigDecimal(1), "freshly grated black pepper", dashUom));

		guacRecipe.setServings(4);
		guacRecipe.setCookTime(0);
		guacRecipe.setPrepTime(10);
		guacRecipe.setDescription(
				"All you really need to make guacamole is ripe avocados and salt. After that, a little lime or lemon juice—a splash of acidity—will help to balance the richness of the avocado. Then if you want, add chopped cilantro, chiles, onion, and/or tomato.");
		guacRecipe.setDifficulty(Difficulty.EASY);
		guacRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");

		String step1 = "1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n";
		String step2 = "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n";
		String step3 =
				"3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n"
						+ "\n"
						+ "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n"
						+ "\n"
						+ "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.";
		String step4 = "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.";

		guacRecipe.setDirections(step1 + step2 + step3 + step4);

		Notes guacNotes = new Notes();
		guacNotes.setRecipeNotes("These are some notes");
		guacNotes.setRecipe(guacRecipe);
		guacRecipe.setNotes(guacNotes);

		System.out.println("Loaded Guacomole recipe.....");

		recipes.add(guacRecipe);
		return recipes;
	}

}
