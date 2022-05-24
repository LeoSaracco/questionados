package ar.com.cdt.questionados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.cdt.questionados.models.Preguntas;

@Repository
public interface IPreguntasRepository extends JpaRepository<Preguntas, Integer> {

	@Query(nativeQuery = true, value = "SELECT p.* FROM preguntas p ORDER BY RAND() LIMIT 1")
	Preguntas getPreguntaRandom();

	@Query(nativeQuery = true, value = "SELECT r.correcta_respuesta FROM preguntas p INNER JOIN respuesta r ON p.id_pregunta=r.pregunta_id WHERE p.id_pregunta=:idPregunta AND r.id_respuesta=:idRespuesta")
	Boolean findByIdPreguntaAndIdRespuesta(@Param("idPregunta") int idPregunta, @Param("idRespuesta") int idRespuesta);
}