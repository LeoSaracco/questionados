package ar.com.cdt.questionados.dto;

public class DTOCategoria {

	private String nombreCategoria;

	private String descripcionCategoria;

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}

	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

	@Override
	public String toString() {
		return "DTOCategoria [nombreCategoria=" + nombreCategoria + ", descripcionCategoria=" + descripcionCategoria
				+ "]";
	}
}