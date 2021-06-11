package com.jacaranda.afdam.dojo.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue(value = "Profesor")
public class Profesor extends Persona {

	// Atributos

	// Relaciones:

	// One to Many con clase
	@OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Clase> classes;

	// Constructor

	public Profesor() {
		super();
		this.classes = new HashSet<>();
	}

	// Get y Set

	public Set<Clase> getClasses() {
		return classes;
	}

	public void setClasses(Set<Clase> classes) {
		this.classes = classes;
	}

}
