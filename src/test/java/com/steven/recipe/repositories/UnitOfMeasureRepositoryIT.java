package com.steven.recipe.repositories;

import com.steven.recipe.domain.UnitOfMeasure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UnitOfMeasureRepositoryIT {

	@Autowired UnitOfMeasureRepository unitOfMeasureRepository;

	@BeforeEach
	void setUp() {
	}

	@Test
	@DirtiesContext // this will reload the context during the test so its an updated context
	public void findByDescriptionTeaspoon() {
		// data is loaded by bootstrap class
		Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Teaspoon");
		assertEquals("Teaspoon", uom.get().getDescription());
	}

	@Test
	public void findByDescriptionTestCup() {
		// data is loaded by bootstrap class
		Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Cup");
		assertEquals("Cup", uom.get().getDescription());
	}
}