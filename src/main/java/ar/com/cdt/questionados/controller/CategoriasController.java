package ar.com.cdt.questionados.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cdt.questionados.dto.DTOCategoria;
import ar.com.cdt.questionados.models.Categorias;
import ar.com.cdt.questionados.service.CategoriasService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController {

	@Autowired
	CategoriasService cs;

	@ApiOperation(value = "access User’s content", notes = "Acceder a contenido si hasRole('USER') o hasRole('MODERATOR') o hasRole('ADMIN').")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/getAllCategorias")
	public List<Categorias> getAllCategorias() {
		return cs.getAllCategorias();
	}

	@ApiOperation(value = "access User’s content", notes = "Acceder a contenido si hasRole('MODERATOR') o hasRole('ADMIN').")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/getCategoriasByID/{id}")
	public Optional<Categorias> getCategoriasByID(@PathVariable("id") Integer idCategoria) {
		return cs.getCategoriasByID(idCategoria);
	}

	@ApiOperation(value = "access User’s content", notes = "Acceder a contenido si hasRole('MODERATOR') o hasRole('ADMIN').")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/saveCategorias")
	public ResponseEntity<Categorias> saveNewCategorias(@RequestBody DTOCategoria c) {
		return new ResponseEntity<Categorias>(cs.save(c), HttpStatus.CREATED);
	}

	@ApiOperation(value = "access User’s content", notes = "Acceder a contenido si hasRole('MODERATOR') o hasRole('ADMIN').")
	@PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
	@PutMapping("/updateCategorias")
	public ResponseEntity<Categorias> updateCategorias(@RequestBody Categorias c) {
		return new ResponseEntity<Categorias>(cs.update(c), HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/deleteCategorias/{id}")
	public Boolean deleteCategorias(@PathVariable("id") Integer idCategoria) {
		return cs.delete(idCategoria);
	}
}