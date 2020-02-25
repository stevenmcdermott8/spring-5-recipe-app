package com.steven.recipe.controllers;

import com.steven.recipe.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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
		String response = controller.getIndexPage(model);

		assertEquals("index", response);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(anyString(), anySet());
	}
}