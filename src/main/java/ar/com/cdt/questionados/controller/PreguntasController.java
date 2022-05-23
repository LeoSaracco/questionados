package ar.com.cdt.questionados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.questionados.dto.DTOPreguntaRespuesta;
import ar.com.cdt.questionados.service.PreguntasService;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntasController {

	@Autowired
	PreguntasService ps;

	@PostMapping("/savePreguntas")
	public ResponseEntity<DTOPreguntaRespuesta> saveNewCategorias(@RequestBody DTOPreguntaRespuesta dto) {
		return new ResponseEntity<DTOPreguntaRespuesta>(ps.save(dto), HttpStatus.CREATED);
	}
}
