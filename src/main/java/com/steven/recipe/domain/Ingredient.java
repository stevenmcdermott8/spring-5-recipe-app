package com.steven.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * stevmc created on 2/16/20
 */
@Data
@EqualsAndHashCode(exclude = { "recipe" })
@Entity
public class Ingredient {

	public Ingredient() {
	}

	public Ingredient(BigDecimal amount, String description, UnitOfMeasure unitOfMeasure) {
		this.amount = amount;
		this.description = description;
		this.unitOfMeasure = unitOfMeasure;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private BigDecimal amount;

	@OneToOne(fetch = FetchType.EAGER) private UnitOfMeasure unitOfMeasure;

	@ManyToOne private Recipe recipe;

}
