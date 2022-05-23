package ar.com.cdt.questionados.dto;

import java.io.Serializable;

public class DTORespuesta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String textoRespuesta;
	private Boolean correctaRespuesta;

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
		return "DTORespuesta [textoRespuesta=" + textoRespuesta + ", correctaRespuesta=" + correctaRespuesta + "]";
	}
}