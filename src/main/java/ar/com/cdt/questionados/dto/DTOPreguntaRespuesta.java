package ar.com.cdt.questionados.dto;

import java.util.ArrayList;

public class DTOPreguntaRespuesta {

	private int idCategoriaPregunta;
	private String enunciadoPregunta;
	private ArrayList<DTORespuesta> respuestas;

	public int getIdCategoriaPregunta() {
		return idCategoriaPregunta;
	}

	public void setIdCategoriaPregunta(int idCategoriaPregunta) {
		this.idCategoriaPregunta = idCategoriaPregunta;
	}

	public String getEnunciadoPregunta() {
		return enunciadoPregunta;
	}

	public void setEnunciadoPregunta(String enunciadoPregunta) {
		this.enunciadoPregunta = enunciadoPregunta;
	}

	public ArrayList<DTORespuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(ArrayList<DTORespuesta> respuestas) {
		this.respuestas = respuestas;
	}

	@Override
	public String toString() {
		return "DTOPreguntaRespuesta [idCategoriaPregunta=" + idCategoriaPregunta + ", enunciadoPregunta="
				+ enunciadoPregunta + ", respuestas=" + respuestas + "]";
	}
}