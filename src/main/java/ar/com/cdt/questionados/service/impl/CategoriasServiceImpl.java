package ar.com.cdt.questionados.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Categorias save(Categorias c) {
		return iCategoriaRepository.save(c);
	}

	@Override
	public Categorias update(Categorias c) {
		Categorias auxCategorias = iCategoriaRepository.getById(c.getIdCategoria());
		auxCategorias.setNombreCategoria(c.getNombreCategoria());
		auxCategorias.setDescripcionCategoria(c.getDescripcionCategoria());
		return iCategoriaRepository.save(auxCategorias);
	}

	@Override
		public Boolean delete(Categorias c) {
		try {
			iCategoriaRepository.delete(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}