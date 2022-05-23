package ar.com.cdt.questionados.dto;

public class DTOPregunta {

	private int idCategoriaPregunta;
	private String enunciadoPregunta;

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

	@Override
	public String toString() {
		return "DTOPreguntaRespuesta [idCategoriaPregunta=" + idCategoriaPregunta + ", enunciadoPregunta="
				+ enunciadoPregunta + "]";
	}
}