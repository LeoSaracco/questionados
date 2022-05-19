package ar.com.cdt.questionados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.questionados.models.Categorias;
import ar.com.cdt.questionados.repository.ICategoriasRepository;

@RestController
public class CategoriasController {

	@Autowired
	ICategoriasRepository iCategoriaRepository;

	@GetMapping("/prueba")
	public String prueba() {
		Categorias c = new Categorias();
		c.setNombreCategoria("Arte");
		c.setDescripcionCategoria("Arte general");
		iCategoriaRepository.save(c);
		return "OK";
	}
}
