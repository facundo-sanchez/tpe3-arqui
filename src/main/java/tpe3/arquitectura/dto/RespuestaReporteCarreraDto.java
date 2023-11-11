package tpe3.arquitectura.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RespuestaReporteCarreraDto implements Serializable {

	private CarreraDto carrera;
	private List<ReporteCarreraDto> reporteCarrera;

	public RespuestaReporteCarreraDto() {
		super();
		this.reporteCarrera = new ArrayList<>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4670857072884139364L;

	/**
	 * @return the carrera
	 */
	public CarreraDto getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(CarreraDto carrera) {
		this.carrera = carrera;
	}

	/**
	 * @return the reporteCarrera
	 */
	public List<ReporteCarreraDto> getReporteCarrera() {
		return reporteCarrera;
	}

	/**
	 * @param reporteCarrera the reporteCarrera to set
	 */
	public void setReporteCarrera(List<ReporteCarreraDto> reporteCarrera) {
		this.reporteCarrera = reporteCarrera;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
