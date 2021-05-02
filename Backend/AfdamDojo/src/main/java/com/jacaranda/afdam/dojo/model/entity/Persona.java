package com.jacaranda.afdam.dojo.model.entity;

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.jacaranda.afdam.dojo.security.model.User;

@Entity
@Table(name = "Persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Persona_Puesto")
public abstract class Persona {

	// Atributos
	/**
	 * Parameters: id lo genera de forma automática en la tabla curp debe ser único
	 * (similar al dni)
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	private String surnames;
	private String birthdate;

	@Column(unique = true)
	private String curp;

	private String tlf;
	private String address;
	private String email;
	private Blob picture;

	// Relaciones:

	// One To One con usuario unidireccional
	@OneToOne
	private User user;

	// One to Many con Mensaje
	@OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Mensaje> messages;

	// Constructores

	public Persona() {
		this.messages = new HashSet<>();
	}

	public Persona(String name, String surnames, String birthdate, String curp, String tlf, String address,
			String email, Blob picture) {
		super();
		this.name = name;
		this.surnames = surnames;
		this.birthdate = birthdate;
		this.curp = curp;
		this.tlf = tlf;
		this.address = address;
		this.email = email;
		this.picture = picture;
		this.messages = new HashSet<>();
	}

	// Get y Set
	
	

	public String getName() {
		return name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public String getTlf() {
		return tlf;
	}

	public void setTlf(String tlf) {
		this.tlf = tlf;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Blob getPicture() {
		return picture;
	}

	public void setPicture(Blob picture) {
		this.picture = picture;
	}

	public int getId() {
		return id;
	}

	public Set<Mensaje> getMessages() {
		return messages;
	}

	public void setMessages(Set<Mensaje> messages) {
		this.messages = messages;
	}
}
