package ar.com.cdt.questionados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.questionados.dto.DTOPreguntaRespuesta;
import ar.com.cdt.questionados.models.Preguntas;
import ar.com.cdt.questionados.service.PreguntasService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/preguntas")
public class PreguntasController {

	@Autowired
	PreguntasService ps;

	@ApiOperation(value = "access User’s content", notes = "Acceder a contenido si hasRole('MODERATOR') o hasRole('ADMIN').")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/savePreguntas")
	public ResponseEntity<DTOPreguntaRespuesta> saveNewPreguntas(@RequestBody DTOPreguntaRespuesta dto) {
		return new ResponseEntity<DTOPreguntaRespuesta>(ps.save(dto), HttpStatus.CREATED);
	}

	@ApiOperation(value = "access User’s content", notes = "Acceder a contenido si hasRole('MODERATOR') o hasRole('ADMIN').")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/getPregunta/{idPregunta}")
	public Optional<Preguntas> getPreguntaByID(@PathVariable("idPregunta") int idPregunta) {
		return ps.getPreguntaByID(idPregunta);
	}
	
	@ApiOperation(value = "access User’s content", notes = "Acceder a contenido si hasRole('USER') o hasRole('MODERATOR') o hasRole('ADMIN').")
	@GetMapping("/getAllPreguntas")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public List<Preguntas> getAllPreg() {
		return ps.getAllPreguntas();
	}
}