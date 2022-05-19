package ar.com.cdt.questionados.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.cdt.questionados.dto.DTOCategoria;
import ar.com.cdt.questionados.models.Categorias;
import ar.com.cdt.questionados.repository.ICategoriasRepository;
import ar.com.cdt.questionados.service.CategoriasService;

@Service
public class CategoriasServiceImpl implements CategoriasService {

	@Autowired
	ICategoriasRepository iCategoriaRepository;

	@Override
	public List<Categorias> getAllCategorias() {
		return iCategoriaRepository.findAll();
	}

	@Override
	public Optional<Categorias> getCategoriasByID(Integer idCategoria) {
		return iCategoriaRepository.findById(idCategoria);
	}

	@Override
	public Categorias save(DTOCategoria c) {
		Categorias cat = new Categorias();
		cat.setNombreCategoria(c.getNombreCategoria());
		cat.setDescripcionCategoria(c.getDescripcionCategoria());
		return iCategoriaRepository.save(cat);
	}

	@Override
	public Categorias update(Categorias c) {
		Categorias auxCategorias = iCategoriaRepository.getById(c.getIdCategoria());
		auxCategorias.setNombreCategoria(c.getNombreCategoria());
		auxCategorias.setDescripcionCategoria(c.getDescripcionCategoria());
		return iCategoriaRepository.save(auxCategorias);
	}

	@Override
	public Boolean delete(Integer idCategoria) {
		try {
			Categorias categoria = new Categorias();
			categoria.setIdCategoria(idCategoria);
			iCategoriaRepository.delete(categoria);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}