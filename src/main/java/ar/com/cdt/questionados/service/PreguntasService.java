package ar.com.cdt.questionados.service;

import java.util.ArrayList;
import java.util.List;

import ar.com.cdt.questionados.dto.DTOPreguntaRespuesta;
import ar.com.cdt.questionados.models.Preguntas;

public interface PreguntasService {

	DTOPreguntaRespuesta save(DTOPreguntaRespuesta dtoPR);

	ArrayList<Preguntas> getPreguntaByID(Integer idPregunta);

	List<Preguntas> getAllPreguntas();
}