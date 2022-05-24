package ar.com.cdt.questionados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.questionados.dto.DTOPreguntaRespuesta;
import ar.com.cdt.questionados.models.Preguntas;
import ar.com.cdt.questionados.service.PreguntasService;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntasController {

	@Autowired
	PreguntasService ps;

	@PostMapping("/savePreguntas")
	public ResponseEntity<DTOPreguntaRespuesta> saveNewPreguntas(@RequestBody DTOPreguntaRespuesta dto) {
		return new ResponseEntity<DTOPreguntaRespuesta>(ps.save(dto), HttpStatus.CREATED);
	}

	@GetMapping("/getPregunta/{idPregunta}")
	public Optional<Preguntas> getPreguntaByID(@PathVariable("idPregunta") int idPregunta) {
		return ps.getPreguntaByID(idPregunta);
	}

	@GetMapping("/getAllPreguntas")
	public List<Preguntas> getAllPreg() {
		return ps.getAllPreguntas();
	}

	//FIXME
	@DeleteMapping("/deletePregunta/{idPregunta}")
	public Boolean deletePregunta(@PathVariable("idPregunta") int idPregunta) {
		return ps.deletePregunta(idPregunta);
	}
}