package tpe3.arquitectura.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="estudiantes_carreras")
public class EstudianteCarreraEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_estudiante")
	private EstudianteEntity estudiante;

	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_carrera")
	private CarreraEntity carrera;

	@Column(name = "inscripcion", nullable = false)
	private int anioInscripcion;

	@Column(name = "graduacion", nullable = false)
	private int anioGraduacion;

	@Column(nullable = true)
	private int antiguedad;

	public EstudianteCarreraEntity() {
		super();
	}

	public EstudianteCarreraEntity(EstudianteEntity estudiante, CarreraEntity carrera, int anioInscripcion,
			int anioGraduacion, int antiguedad) {
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
	public EstudianteEntity getEstudiante() {
		return estudiante;
	}

	/**
	 * @param estudiante the estudiante to set
	 */
	public void setEstudiante(EstudianteEntity estudiante) {
		this.estudiante = estudiante;
	}

	/**
	 * @return the carrera
	 */
	public CarreraEntity getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera the carrera to set
	 */
	public void setCarrera(CarreraEntity carrera) {
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
}
