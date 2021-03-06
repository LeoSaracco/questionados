package ar.com.cdt.questionados.service;

import java.util.List;
import java.util.Optional;

import ar.com.cdt.questionados.dto.DTOCategoria;
import ar.com.cdt.questionados.models.Categorias;

public interface CategoriasService {

	List<Categorias> getAllCategorias();
	
	Optional<Categorias> getCategoriasByID(Integer idCategoria);

	Categorias save(DTOCategoria c);

	Categorias update(Categorias c);

	Boolean delete(Integer idCategoria);
}