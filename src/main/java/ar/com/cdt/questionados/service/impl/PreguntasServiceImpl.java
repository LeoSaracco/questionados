package ar.com.cdt.questionados.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cdt.questionados.dto.DTOPreguntaRespuesta;
import ar.com.cdt.questionados.models.Preguntas;
import ar.com.cdt.questionados.models.Respuesta;
import ar.com.cdt.questionados.repository.IPreguntasRepository;
import ar.com.cdt.questionados.service.PreguntasService;

@Service
public class PreguntasServiceImpl implements PreguntasService {

	@Autowired
	IPreguntasRepository preguntasRepository;

	@Override
	public DTOPreguntaRespuesta save(Preguntas p, ArrayList<Respuesta> listaRespuestas) {
		// Controlo de que no haya más de 2 respuestas correctas
		DTOPreguntaRespuesta a = new DTOPreguntaRespuesta();

		int contadorCorrectas = 0;
		for (Respuesta respuesta : listaRespuestas) {
			if (respuesta.getCorrectaRespuesta()) {
				contadorCorrectas++;
			}
			if (contadorCorrectas > 1) {
				return null;
			}
		}

		// Guardo la pregunta
		preguntasRepository.save(p);
		return a;
	}

}
