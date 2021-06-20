package com.jacaranda.afdam.dojo.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jacaranda.afdam.dojo.model.entity.enums.AlergiaGravedad;

@Service("alergiaGravedadService")
public class AlergiaGravedadService {

	// Obtenemos los diferentes niveles de gravedad de alergia
	public List<String> getAlergiasGravedad() {

		List<String> alergiasGravedad = new ArrayList<String>();
		alergiasGravedad.add(AlergiaGravedad.LEVE.name());
		alergiasGravedad.add(AlergiaGravedad.MODERADO.name());
		alergiasGravedad.add(AlergiaGravedad.GRAVE.name());

		return alergiasGravedad;
	}

}
