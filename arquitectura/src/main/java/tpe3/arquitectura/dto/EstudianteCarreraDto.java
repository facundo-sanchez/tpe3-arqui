package tpe3.arquitectura.dto;

import java.io.Serializable;

public class EstudianteCarreraDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private EstudianteDto estudiante;
	private CarreraDto carrera;
	private int anioInscripcion;
	private int anioGraduacion;
	private int antiguedad;

	/**
	 * 
	 */
	public EstudianteCarreraDto() {
		super();
	}

	/**
	 * 
	 * @param estudiante
	 * @param carrera
	 * @param anioInscripcion
	 * @param anioGraduacion
	 * @param antiguedad
	 */
	public EstudianteCarreraDto(EstudianteDto estudiante, CarreraDto carrera, int anioInscripcion, int anioGraduacion,
			int antiguedad) {
		super();
		this.estudiante = estudiante;
		this.carrera = carrera;
		this.anioInscripcion = anioInscripcion;
		this.anioGraduacion = anioGraduacion;
		this.antiguedad = antiguedad;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the estudiante
	 */
	public EstudianteDto getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante the estudiante to set
	 */
	public void setEstudiante(EstudianteDto estudiante) {
		this.estudiante = estudiante;
	}

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
	 * @return the anioInscripcion
	 */
	public int getAnioInscripcion() {
		return anioInscripcion;
	}

	/**
	 * @param anioInscripcion the anioInscripcion to set
	 */
	public void setAnioInscripcion(int anioInscripcion) {
		this.anioInscripcion = anioInscripcion;
	}

	/**
	 * @return the anioGraduacion
	 */
	public int getAnioGraduacion() {
		return anioGraduacion;
	}

	/**
	 * @param anioGraduacion the anioGraduacion to set
	 */
	public void setAnioGraduacion(int anioGraduacion) {
		this.anioGraduacion = anioGraduacion;
	}

	/**
	 * @return the antiguedad
	 */
	public int getAntiguedad() {
		return antiguedad;
	}

	/**
	 * @param antiguedad the antiguedad to set
	 */
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
