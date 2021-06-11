package com.jacaranda.afdam.dojo.model.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Reserva {

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// Fecha de la reserva del producto
	private LocalDate reservationDate;
	// Cantidad de productos
	private int amount;

	// Relaciones:

	// Many to One con Alumno
	@ManyToOne(optional = false)
	@JoinColumn(name = "idAlumno", foreignKey = @ForeignKey(name = "FK_Alumno_reserva"))
	private Alumno alumno;

	// Many to Many con Producto
	@ManyToMany(targetEntity = Producto.class)
	private Set<Producto> products;

	// Constructores

	public Reserva() {
		this.products = new HashSet<>();
	}

	public Reserva(LocalDate reservationDate, int amount) {
		super();
		this.reservationDate = reservationDate;
		this.amount = amount;
		this.products = new HashSet<>();
	}

	// Get y Set

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Set<Producto> getProduct() {
		return products;
	}

	public void setProduct(Set<Producto> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}
}
