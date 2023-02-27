package com.pxl.superhero.api;

import com.pxl.superhero.domain.Superhero;

public class SuperheroDTO {

	private final Long id;
	private final String firstName;
	private final String lastName;
	private final String superheroName;

	public SuperheroDTO(Superhero superhero) {
		this.id = superhero.getId();
		this.firstName = superhero.getFirstName();
		this.lastName = superhero.getLastName();
		this.superheroName = superhero.getSuperheroName();
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSuperheroName() {
		return superheroName;
	}
}
