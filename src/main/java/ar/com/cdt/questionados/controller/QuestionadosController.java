package ar.com.cdt.questionados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.questionados.models.Preguntas;
import ar.com.cdt.questionados.service.PreguntasService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/questionados")
public class QuestionadosController {

	@Autowired
	PreguntasService ps;

	@ApiOperation(value = "access User’s content", notes = "Acceder a contenido si hasRole('USER') o hasRole('MODERATOR') o hasRole('ADMIN').")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/getPreguntaRandom")
	public Preguntas getPreguntaRandom() {
		return ps.getPreguntaRandom();
	}

	@ApiOperation(value = "access User’s content", notes = "Acceder a contenido si hasRole('USER') o hasRole('MODERATOR') o hasRole('ADMIN').")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/checkPreguntaRespuesta/idPregunta/{idPregunta}/idRespuesta/{idRespuesta}")
	public Boolean getVeracidadPreguntaRespuesta(@PathVariable("idPregunta") int idPregunta,
			@PathVariable("idRespuesta") int idRespuesta) {
		return ps.getRespuestaVerdadera(idPregunta, idRespuesta);
	}
}