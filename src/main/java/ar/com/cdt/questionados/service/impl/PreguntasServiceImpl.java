package ar.com.cdt.questionados.service.impl;

import java.util.ArrayList;
import java.util.List;

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
				System.out.println("NO SE GUARDA CONTADOR " + contadorCorrectas);
				return null;
			}
		}

		// Guardo la pregunta
		Preguntas pregToSave = new Preguntas();
		pregToSave.setEnunciadoPregunta(dtoPR.getEnunciadoPregunta());

		Categorias categoria = new Categorias();
		categoria = categoriaRepository.findById(dtoPR.getIdCategoriaPregunta()).get();
		pregToSave.setCategoriaIdPregunta(categoria);
		try {
			Preguntas pregunta = preguntasRepository.save(pregToSave);
			for (DTORespuesta dtoRespuesta : dtoPR.getRespuestas()) {
				Respuesta respuesta = new Respuesta();
				respuesta.setTextoRespuesta(dtoRespuesta.getTextoRespuesta());
				respuesta.setCorrectaRespuesta(dtoRespuesta.getCorrectaRespuesta());
				respuesta.setPregunta(pregunta);
				respuestasRepository.save(respuesta);
			}

			dtoFinal.setEnunciadoPregunta(pregToSave.getEnunciadoPregunta());
			dtoFinal.setIdCategoriaPregunta(categoria.getIdCategoria());
			dtoFinal.setRespuestas(dtoPR.getRespuestas());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoFinal;
	}

	@Override
	public ArrayList<Preguntas> getPreguntaByID(Integer idPregunta) {
		//Optional<Preguntas> aux = preguntasRepository.findById(idPregunta);

		return null;
	}

	@Override
	public List<Preguntas> getAllPreguntas() {
		// TODO Auto-generated method stub
		return preguntasRepository.findAll();
	}
	

}


