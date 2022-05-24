package ar.com.cdt.questionados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.cdt.questionados.models.Preguntas;

@Repository
public interface IPreguntasRepository extends JpaRepository<Preguntas, Integer> {

//	//FIXME
//	@Query("SELECT * FROM preguntas p INNER JOIN respuesta r ON p.id_pregunta=r.pregunta_id WHERE p.id_pregunta=:id_pregunta")
//	public ArrayList<Preguntas> FindByIdComplete(@Param("id_pregunta")int id);
	
}