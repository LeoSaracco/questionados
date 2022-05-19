package ar.com.cdt.questionados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.cdt.questionados.models.Categorias;

@Repository
public interface ICategoriasRepository extends JpaRepository<Categorias, Integer> {

}