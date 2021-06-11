package com.jacaranda.afdam.dojo.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.jacaranda.afdam.dojo.model.entity.enums.CategoriaProducto;
import com.jacaranda.afdam.dojo.model.entity.enums.ColorProducto;
import com.jacaranda.afdam.dojo.model.entity.enums.TallaProducto;

@Entity
public class Producto {

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String description;
	private TallaProducto size;
	private double price;
	private ColorProducto color;
	private CategoriaProducto category;
	

	// categoria (Training, armas, protección, accesorios), color, talla
	// (XS,XL,S,M,L, XXL), Precio

	// Relaciones:

	// Many to Many con reserva
	@ManyToMany(targetEntity = Reserva.class)
	private Set<Reserva> bookings;

	// Many to Many con catálogo
	@ManyToMany(targetEntity = Catalogo.class)
	private Set<Catalogo> catalogs;

	// Constructor
	public Producto() {
		this.bookings = new HashSet<>();
		this.catalogs = new HashSet<>();
	}

	public Producto(String name, String description, TallaProducto size, double price, 
			ColorProducto color, CategoriaProducto category) {
		super();
		this.name = name;
		this.description = description;
		this.size = size;
		this.price = price;
		this.color = color;
		this.category = category;
		this.bookings = new HashSet<>();
		this.catalogs = new HashSet<>();
	}

	// Get y Set

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TallaProducto getSize() {
		return size;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ColorProducto getColor() {
		return color;
	}
	
	public CategoriaProducto getCategory() {
		return category;
	}

	public Set<Reserva> getBookings() {
		return bookings;
	}

	public void setBookings(Set<Reserva> bookings) {
		this.bookings = bookings;
	}

	public Set<Catalogo> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(Set<Catalogo> catalogs) {
		this.catalogs = catalogs;
	}
}
