package ar.com.cdt.questionados.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cdt.questionados.dto.DTOPreguntaRespuesta;
import ar.com.cdt.questionados.dto.DTORespuesta;
import ar.com.cdt.questionados.models.Categorias;
import ar.com.cdt.questionados.models.Preguntas;
import ar.com.cdt.questionados.models.Respuesta;
import ar.com.cdt.questionados.repository.ICategoriasRepository;
import ar.com.cdt.questionados.repository.IPreguntasRepository;
import ar.com.cdt.questionados.repository.IRespuestasRepository;
import ar.com.cdt.questionados.service.PreguntasService;

@Service
public class PreguntasServiceImpl implements PreguntasService {

	@Autowired
	IPreguntasRepository preguntasRepository;

	@Autowired
	IRespuestasRepository respuestasRepository;

	@Autowired
	ICategoriasRepository categoriaRepository;

	@Override
	public DTOPreguntaRespuesta save(DTOPreguntaRespuesta dtoPR) {

		System.out.println("============= DTO: " + dtoPR);
		// Controlo de que no haya más de 2 respuestas correctas
		DTOPreguntaRespuesta dtoFinal = new DTOPreguntaRespuesta();

		// https://www.youtube.com/watch?v=j6D-9XC-mDQ

		int contadorCorrectas = 0;
		for (DTORespuesta respuesta : dtoPR.getRespuestas()) {
			if (respuesta.getCorrectaRespuesta()) {
				contadorCorrectas++;
			}
			if (contadorCorrectas > 1) {
				return null;
			}
		}

		// Guardo la pregunta
		Preguntas pregToSave = new Preguntas();
		pregToSave.setEnunciadoPregunta(dtoPR.getEnunciadoPregunta());
		Categorias c = new Categorias();
		c = categoriaRepository.findById(dtoPR.getIdCategoriaPregunta()).get();
		pregToSave.setCategoriaIdPregunta(c);
		try {
			Preguntas aux = preguntasRepository.save(pregToSave);
			for (DTORespuesta dtoRespuesta : dtoPR.getRespuestas()) {
				Respuesta r = new Respuesta();
				r.setTextoRespuesta(dtoRespuesta.getTextoRespuesta());
				r.setCorrectaRespuesta(dtoRespuesta.getCorrectaRespuesta());
				r.setPregunta(aux);
				respuestasRepository.save(r);
			}

			dtoFinal.setEnunciadoPregunta(pregToSave.getEnunciadoPregunta());
			dtoFinal.setIdCategoriaPregunta(c.getIdCategoria());
			dtoFinal.setRespuestas(dtoPR.getRespuestas());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoFinal;
	}
}
