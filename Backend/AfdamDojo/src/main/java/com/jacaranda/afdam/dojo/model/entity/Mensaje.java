package com.jacaranda.afdam.dojo.model.entity;



import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

@Entity
public class Mensaje {

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;
	private String subtitle;
	private String description;
	// @Enumerated(EnumType.STRING)
	// private Tipo type;

	// Relaciones:

	// Many to One con Persona para Profesor y Administrador
	@ManyToOne
	@JoinColumn(name = "idRemitente", foreignKey = @ForeignKey(name = "FK_Remitente_mensaje"))
	private Persona sender;

	// Many to Many Alumno
//	@ManyToMany(mappedBy = "mensajes")
//	private Set<Alumno> students;

	// Constructor
	public Mensaje() {
		//this.students = new HashSet<>();
	}

	public Mensaje(String title, String subtitle, String description) {
		super();
		this.title = title;
		this.subtitle = subtitle;
		this.description = description;
		//this.students = new HashSet<>();
	}

	// Get y Set

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Persona getSender() {
		return sender;
	}

	public void setSender(Persona sender) {
		this.sender = sender;
	}

//	public Set<Alumno> getStudents() {
//		return students;
//	}
//
//	public void setStudents(Set<Alumno> students) {
//		this.students = students;
//	}

	public int getId() {
		return id;
	}
}
