package ar.com.cdt.questionados.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "preguntas")
public class Preguntas {

	@Id
	@Column(name = "idPregunta")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPregunta;

	@Column(name = "enunciadoPregunta", nullable = false)
	private String enunciadoPregunta;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
	private Categorias categoriaIdPregunta;

	@OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL)
	private List<Respuesta> respuestas = new ArrayList<>();

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getEnunciadoPregunta() {
		return enunciadoPregunta;
	}

	public void setEnunciadoPregunta(String enunciadoPregunta) {
		this.enunciadoPregunta = enunciadoPregunta;
	}

	public Categorias getCategoriaIdPregunta() {
		return categoriaIdPregunta;
	}

	public void setCategoriaIdPregunta(Categorias categoriaIdPregunta) {
		this.categoriaIdPregunta = categoriaIdPregunta;
	}

	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}

	@Override
	public String toString() {
		return "Preguntas [idPregunta=" + idPregunta + ", enunciadoPregunta=" + enunciadoPregunta
				+ ", categoriaIdPregunta=" + categoriaIdPregunta + ", respuestas=" + respuestas + "]";
	}
}