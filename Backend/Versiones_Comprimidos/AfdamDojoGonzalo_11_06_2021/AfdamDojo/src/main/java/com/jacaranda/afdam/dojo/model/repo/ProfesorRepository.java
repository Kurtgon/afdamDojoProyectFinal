package com.jacaranda.afdam.dojo.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.afdam.dojo.model.entity.Profesor;

@Repository
public interface ProfesorRepository extends JpaRepository <Profesor, Integer> {

	public Profesor findProfesorByCurp(String curp);
}
