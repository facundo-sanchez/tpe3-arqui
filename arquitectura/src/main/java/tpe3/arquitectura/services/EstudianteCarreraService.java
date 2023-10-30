package tpe3.arquitectura.services;

import java.util.List;

import tpe3.arquitectura.dto.EstudianteCarreraDto;

public interface EstudianteCarreraService {

	public EstudianteCarreraDto matricularEstudiante(EstudianteCarreraDto estudianteCarrera);
	
//	public List<EstudianteCarreraDto> getEstudianteByCarreraAndCiudad(String nombreCarrera, String ciudad);
}
