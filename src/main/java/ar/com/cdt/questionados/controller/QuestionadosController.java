package ar.com.cdt.questionados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.questionados.models.Preguntas;
import ar.com.cdt.questionados.service.PreguntasService;

@RestController
@RequestMapping("/api/questionados")
public class QuestionadosController {

	@Autowired
	PreguntasService ps;

	@GetMapping("/getPreguntaRandom")
	public Preguntas getPreguntaRandom() {
		return ps.getPreguntaRandom();
	}
}
