package com.jacaranda.afdam.dojo.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.afdam.dojo.model.entity.enums.Disciplinas;

@Service("disciplinaService")
public class DisciplinaService {

	// Obtenemos todas las disciplinas
	public List<String> getDisciplinas() {

		List<String> disciplinas = new ArrayList<String>();

		disciplinas.add(Disciplinas.CARDIOFITBAG.name());
		disciplinas.add(Disciplinas.JIUJITSU.name());
		disciplinas.add(Disciplinas.KICKBOXING.name());
		disciplinas.add(Disciplinas.MMA.name());
		disciplinas.add(Disciplinas.NINJUSTSU.name());
		disciplinas.add(Disciplinas.TAICHI.name());

		return disciplinas;

	}

}
