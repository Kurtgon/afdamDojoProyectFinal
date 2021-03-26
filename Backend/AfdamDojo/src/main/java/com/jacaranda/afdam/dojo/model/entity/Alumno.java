package com.jacaranda.afdam.dojo.model.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;

import com.jacaranda.afdam.dojo.model.entity.enums.Disciplinas;

@Entity
@DiscriminatorValue(value = "Alumno")
public class Alumno extends Persona {

	// Atributos

	private String contact;

	@Enumerated(EnumType.STRING)
	private Disciplinas discipline;

	// @NonNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate paymentDate;

	// Relaciones:

	// Many to Many Alergia
	@ManyToMany(targetEntity = Alergia.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Alergia> allergy;

	// One to Many Reserva
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Reserva> reservation;

	// Many to Many Clase
	@ManyToMany(targetEntity = Clase.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Clase> classes;

	// Constructor

	public Alumno() {
		this.allergy = new HashSet<>();
		this.reservation = new HashSet<>();
		this.classes = new HashSet<>();
	}

	public Alumno(String contact, Disciplinas discipline, LocalDate paymentDate) {
		super();
		this.contact = contact;
		this.discipline = discipline;
		this.paymentDate = paymentDate;
		this.allergy = new HashSet<>();
		this.reservation = new HashSet<>();
		this.classes = new HashSet<>();
	}

	// Get y Set

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Disciplinas getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Disciplinas discipline) {
		this.discipline = discipline;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Set<Alergia> getAllergy() {
		return allergy;
	}

	public void setAllergy(Set<Alergia> allergy) {
		this.allergy = allergy;
	}

	public Set<Reserva> getReservation() {
		return reservation;
	}

	public void setReservation(Set<Reserva> reservation) {
		this.reservation = reservation;
	}

	public Set<Clase> getClasses() {
		return classes;
	}

	public void setClasses(Set<Clase> classes) {
		this.classes = classes;
	}

}
