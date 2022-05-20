package ar.com.cdt.questionados.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "respuesta")
public class Respuesta {

	@Id
	@Column(name = "idRespuesta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRespuesta;
	@Column(name = "textoRespuesta", nullable = false)
	private String textoRespuesta;
	@Column(name = "correctaRespuesta", nullable = false)
	private Boolean correctaRespuesta;

	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getTextoRespuesta() {
		return textoRespuesta;
	}

	public void setTextoRespuesta(String textoRespuesta) {
		this.textoRespuesta = textoRespuesta;
	}

	public Boolean getCorrectaRespuesta() {
		return correctaRespuesta;
	}

	public void setCorrectaRespuesta(Boolean correctaRespuesta) {
		this.correctaRespuesta = correctaRespuesta;
	}

	@Override
	public String toString() {
		return "Respuesta [idRespuesta=" + idRespuesta + ", textoRespuesta=" + textoRespuesta + ", correctaRespuesta="
				+ correctaRespuesta + "]";
	}
}