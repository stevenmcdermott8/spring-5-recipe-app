package com.steven.recipe;

import com.steven.recipe.domain.Recipe;
import com.steven.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

	@Mock RecipeRepository recipeRepository;

	// TODO: how to initialize before entire class?
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository);
	}

	@Test
	public void testEmptyResponse() {
		Set<Recipe> recipes = recipeService.getRecipes();
		System.out.println(recipes.size());
		assertEquals(0, recipes.size());
	}

	@Test
	public void testNonEmptyResponse() {
		Recipe recipe = new Recipe();
		HashSet<Recipe> recipeHashSet = new HashSet<>();
		recipeHashSet.add(recipe);

		when(recipeRepository.findAll()).thenReturn(recipeHashSet);
		Set<Recipe> recipes = recipeService.getRecipes();
		System.out.println(recipes.size());
		assertEquals(1, recipes.size());
		verify(recipeRepository, times(1)).findAll();
	}
}