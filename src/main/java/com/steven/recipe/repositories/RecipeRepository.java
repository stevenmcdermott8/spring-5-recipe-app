package com.steven.recipe.repositories;

import com.steven.recipe.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

/**
 * stevmc created on 2/16/20
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
