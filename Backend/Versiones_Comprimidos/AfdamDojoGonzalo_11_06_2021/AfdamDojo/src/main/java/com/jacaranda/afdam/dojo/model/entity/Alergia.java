package com.jacaranda.afdam.dojo.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.jacaranda.afdam.dojo.model.entity.enums.AlergiaGravedad;

@Entity
public class Alergia {

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	// enum gravedad tres estado: Leve, moderado, grave
	@Enumerated(EnumType.STRING)
	private AlergiaGravedad serious;

	private String alergyName;

	// Relación con Alumno Many to Many
	@ManyToMany(targetEntity = Alumno.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Alumno> students;

	// Constructor

	public Alergia() {
		this.students = new HashSet<>();
	}

	// Get y Set

	public Alergia(AlergiaGravedad serious, String alergyName) {
		super();
		this.serious = serious;
		this.alergyName = alergyName;
		this.students = new HashSet<>();
	}

	public Set<Alumno> getStudents() {
		return students;
	}

	public void setStudents(Set<Alumno> students) {
		this.students = students;
	}

	public String getAlergyName() {
		return alergyName;
	}

	public void setAlergyName(String alergyName) {
		this.alergyName = alergyName;
	}

	public AlergiaGravedad getSerious() {
		return serious;
	}

}
