package com.steven.recipe.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * stevmc created on 2/16/20
 */
@Entity
public class Ingredient {

	public Ingredient() {
	}

	public Ingredient(BigDecimal amount, String description, UnitOfMeasure unitOfMeasure, Recipe recipe) {
		this.amount = amount;
		this.description = description;
		this.unitOfMeasure = unitOfMeasure;
		this.recipe = recipe;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;

	@OneToOne(fetch = FetchType.EAGER) private UnitOfMeasure unitOfMeasure;

	@ManyToOne private Recipe recipe;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public UnitOfMeasure getUnitOfMeasure() {
		return unitOfMeasure;
	}

	public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}
