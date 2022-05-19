package ar.com.cdt.questionados.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.cdt.questionados.dto.DTOCategoria;
import ar.com.cdt.questionados.models.Categorias;
import ar.com.cdt.questionados.service.CategoriasService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

	@Autowired
	CategoriasService cs;

	@GetMapping("/getAllCategorias")
	public List<Categorias> getAllCategorias() {
		return cs.getAllCategorias();
	}

	@PostMapping("/saveCategorias")
	public ResponseEntity<Categorias> saveNewCategorias(@RequestBody DTOCategoria c) {
		return new ResponseEntity<Categorias>(cs.save(c), HttpStatus.CREATED);
	}

	@PutMapping("/updateCategorias")
	public ResponseEntity<Categorias> updateCategorias(@RequestBody Categorias c) {
		return new ResponseEntity<Categorias>(cs.update(c), HttpStatus.OK);
	}

	@DeleteMapping("/deleteCategorias/{id}")
	public Boolean deleteCategorias(@PathVariable("id") Integer id) {
		return cs.delete(id);
	}
}