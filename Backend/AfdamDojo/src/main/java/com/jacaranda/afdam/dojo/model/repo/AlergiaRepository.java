package com.jacaranda.afdam.dojo.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jacaranda.afdam.dojo.model.entity.Alergia;


@Repository
public interface AlergiaRepository extends JpaRepository <Alergia, Integer>{

	public Alergia findAlergiaByAlergyName(String alergyName);
	
}
