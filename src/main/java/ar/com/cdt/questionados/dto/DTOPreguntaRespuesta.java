package ar.com.cdt.questionados.dto;

import java.util.ArrayList;
import java.util.List;

import ar.com.cdt.questionados.models.Respuesta;

public class DTOPreguntaRespuesta {

	private String categoriaPregunta;
	private String enunciadoPregunta;
	private List<Respuesta> listaRespuestas = new ArrayList<>();

	public String getCategoriaPregunta() {
		return categoriaPregunta;
	}

	public void setCategoriaPregunta(String categoriaPregunta) {
		this.categoriaPregunta = categoriaPregunta;
	}

	public String getEnunciadoPregunta() {
		return enunciadoPregunta;
	}

	public void setEnunciadoPregunta(String enunciadoPregunta) {
		this.enunciadoPregunta = enunciadoPregunta;
	}

	public List<Respuesta> getListaRespuestas() {
		return listaRespuestas;
	}

	public void setListaRespuestas(List<Respuesta> listaRespuestas) {
		this.listaRespuestas = listaRespuestas;
	}

	@Override
	public String toString() {
		return "DTOPreguntaRespuesta [categoriaPregunta=" + categoriaPregunta + ", enunciadoPregunta="
				+ enunciadoPregunta + ", listaRespuestas=" + listaRespuestas + "]";
	}
}