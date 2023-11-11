package tpe3.arquitectura.dto;

import java.io.Serializable;

public class ReporteCarreraDto implements Serializable {

	private static final long serialVersionUID = -4670857072884139364L;
	private int anio;
	private int inscriptos;
	private int egresados;

	/**
	 * @return the inscriptos
	 */
	public int getInscriptos() {
		return inscriptos;
	}

	/**
	 * @param inscriptos the inscriptos to set
	 */
	public void setInscriptos(int inscriptos) {
		this.inscriptos = inscriptos;
	}

	/**
	 * @return the egresados
	 */
	public int getEgresados() {
		return egresados;
	}

	/**
	 * @param egresados the egresados to set
	 */
	public void setEgresados(int egresados) {
		this.egresados = egresados;
	}

	/**
	 * @return the anio
	 */
	public int getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
	 */
	public void setAnio(int anio) {
		this.anio = anio;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Año " + anio + " - Inscriptos " + inscriptos + ", Egresados " + egresados;
	}
}
