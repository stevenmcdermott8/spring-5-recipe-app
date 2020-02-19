package com.steven.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

/**
 * stevmc created on 2/16/20
 */
@Data
@EqualsAndHashCode(exclude = { "recipes" })
@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@ManyToMany(mappedBy = "categories") private Set<Recipe> recipes;

}
