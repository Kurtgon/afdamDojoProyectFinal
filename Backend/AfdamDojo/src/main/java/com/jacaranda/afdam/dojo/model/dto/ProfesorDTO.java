package com.jacaranda.afdam.dojo.model.dto;

import java.sql.Blob;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jacaranda.afdam.dojo.model.entity.Clase;

@JsonInclude(Include.NON_NULL)
public class ProfesorDTO {

	// Atributos
	private String name;
	private String surnames;
	private String birthdate;
	private String curp;
	private String tlf;
	private String address;
	private String email;
	private Blob picture;
	
	private Set<Clase> classes;

	// Get y Set
	public String getName() {
		return name;
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

	public Set<Clase> getClasses() {
		return classes;
	}

	public void setClasses(Set<Clase> classes) {
		this.classes = classes;
	}
	
	
}
