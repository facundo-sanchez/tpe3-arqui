package tpe3.arquitectura.dto;

public class RepuestaCarreraInscriptosDto {
	private CarreraDto carrera;
	private int inscriptos;

	public RepuestaCarreraInscriptosDto() {
		super();
	}

	/**
	 * 
	 * @param carrera
	 * @param inscriptos
	 */
	public RepuestaCarreraInscriptosDto(CarreraDto carrera, int inscriptos) {
		super();
		this.carrera = carrera;
		this.inscriptos = inscriptos;
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

	@Override
	public String toString() {
		return "Carrera: " + carrera.getNombre() + ", Cantidad de Inscriptos: " + inscriptos;
	}
}
