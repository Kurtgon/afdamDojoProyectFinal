package com.jacaranda.AfdamDojo.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.jacaranda.AfdamDojo.model.entity.enums.Disciplinas;

@Entity
public class Clase {

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	private Disciplinas discipline;

	private String starHour;
	private String endHour;

	// Relaciones:

	// Many to Many con Alumno
	@ManyToMany(targetEntity = Alumno.class, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	private Set<Alumno> students;

	// Many To One con profesor
	@ManyToOne(optional = false)
	@JoinColumn(name = "idProfesor", foreignKey = @ForeignKey(name = "FK_Profesor_clases"))
	private Profesor profesor;

	// Constructor
	public Clase() {
		this.students = new HashSet<>();
		this.profesor = new Profesor();
	}

	public Clase(Disciplinas discipline, String starHour, String endHour, Profesor profesor) {
		super();
		this.discipline = discipline;
		this.starHour = starHour;
		this.endHour = endHour;
		this.profesor = profesor;
		this.students = new HashSet<>();
	}

	// Get y Set

	public Disciplinas getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Disciplinas discipline) {
		this.discipline = discipline;
	}

	public String getStarHour() {
		return starHour;
	}

	public void setStarHour(String starHour) {
		this.starHour = starHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public Set<Alumno> getStudents() {
		return students;
	}

	public void setStudents(Set<Alumno> students) {
		this.students = students;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public int getId() {
		return id;
	}
}
