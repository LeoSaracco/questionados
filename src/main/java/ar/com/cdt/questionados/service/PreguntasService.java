package ar.com.cdt.questionados.service;

import java.util.List;
import java.util.Optional;

import ar.com.cdt.questionados.dto.DTOPreguntaRespuesta;
import ar.com.cdt.questionados.models.Preguntas;

public interface PreguntasService {

	DTOPreguntaRespuesta save(DTOPreguntaRespuesta dtoPR);

	Optional<Preguntas> getPreguntaByID(Integer idPregunta);

	List<Preguntas> getAllPreguntas();
}