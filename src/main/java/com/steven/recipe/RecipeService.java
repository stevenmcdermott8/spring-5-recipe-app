package com.steven.recipe;

import com.steven.recipe.domain.Recipe;

import java.util.Set;

/**
 * stevmc created on 2/16/20
 */
public interface RecipeService {

	Set<Recipe> getRecipes();
}
