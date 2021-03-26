package com.jacaranda.afdam.dojo.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.afdam.dojo.model.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository <Alumno,Integer> {

}
