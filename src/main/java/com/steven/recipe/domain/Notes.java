package com.steven.recipe.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * stevmc created on 2/16/20
 */
@Data
@EqualsAndHashCode(exclude = { "recipe" })
@Entity
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne private Recipe recipe;

	@Lob private String recipeNotes;

	public Notes() {
	}

	protected boolean canEqual(final Object other) {
		return other instanceof Notes;
	}

}
