package com.jacaranda.AfdamDojo.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Catalogo {

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Relación Many to Many con Producto
	@ManyToMany(targetEntity = Producto.class)
	private Set<Producto> products;

	// Constructores

	public Catalogo() {
		this.products = new HashSet<>();
	}

	// Get y Set

	public Set<Producto> getProducts() {
		return products;
	}

	public void setProducts(Set<Producto> products) {
		this.products = products;
	}
}
