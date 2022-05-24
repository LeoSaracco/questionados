package ar.com.cdt.questionados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.cdt.questionados.models.Preguntas;

@Repository
public interface IPreguntasRepository extends JpaRepository<Preguntas, Integer> {

	@Query(nativeQuery = true, value = "SELECT p.* FROM preguntas p ORDER BY RAND() LIMIT 1")
	Preguntas getPreguntaRandom();
}