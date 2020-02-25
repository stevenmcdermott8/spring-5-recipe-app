package com.steven.recipe.controllers;

import com.steven.recipe.RecipeService;
import com.steven.recipe.domain.Recipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class IndexControllerTest {

	IndexController controller;

	@Mock RecipeService recipeService;

	@Mock Model model;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		controller = new IndexController(recipeService);
	}

	@Test
	public void testGetIndexPage() {
		// given
		Set<Recipe> recipeSet = new HashSet<>();
		// the equals method is overridden so we have to have unique recipe objects otherwise two empty
		// recipe objects will be equal based on id
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		recipeSet.add(recipe);
		Recipe recipe2 = new Recipe();
		recipe.setId(2L);
		recipeSet.add(recipe2);

		// when
		when(recipeService.getRecipes()).thenReturn(recipeSet);

		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		// then
		String response = controller.getIndexPage(model);

		assertEquals("index", response);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(anyString(), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}
}