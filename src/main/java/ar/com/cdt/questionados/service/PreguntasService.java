package ar.com.cdt.questionados.service;

import java.util.ArrayList;

import ar.com.cdt.questionados.dto.DTOPreguntaRespuesta;
import ar.com.cdt.questionados.models.Preguntas;
import ar.com.cdt.questionados.models.Respuesta;

public interface PreguntasService {

	DTOPreguntaRespuesta save(Preguntas p, ArrayList<Respuesta> listaRespuestas);
	
}