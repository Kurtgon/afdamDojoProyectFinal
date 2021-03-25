package com.jacaranda.AfdamDojo.model.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jacaranda.AfdamDojo.model.entity.enums.TipoPago;

@Entity
public class Pago {

	// Atributos

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Enumerated(EnumType.STRING)
	private TipoPago paymenType;

	// Relación Many to One con alumno
	@ManyToOne(optional = false)
	@JoinColumn(name = "idAlumno", foreignKey = @ForeignKey(name = "FK_Alumno_pagos"))
	private Alumno alumno;

	// Constructor
	public Pago() {
	}

	public Pago(TipoPago paymenType) {
		super();
		this.paymenType = paymenType;
	}

	// Get y Set
	public TipoPago getPaymenType() {
		return paymenType;
	}

	public void setPaymenType(TipoPago paymenType) {
		this.paymenType = paymenType;
	}

	public Alumno getIdAlumno() {
		return alumno;
	}

	public void setIdAlumno(Alumno idAlumno) {
		this.alumno = idAlumno;
	}

	public int getId() {
		return id;
	}
}
