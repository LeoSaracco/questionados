package ar.com.cdt.questionados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.cdt.questionados.models.Respuesta;

@Repository
public interface IRespuestasRepository extends JpaRepository<Respuesta, Integer> {

}