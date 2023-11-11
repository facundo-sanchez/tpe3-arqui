package tpe3.arquitectura.mappers;

import java.util.ArrayList;
import java.util.List;

import tpe3.arquitectura.dto.EstudianteDto;
import tpe3.arquitectura.entities.EstudianteEntity;

public class EstudianteMapper {

	/**
	 * 
	 * @param estudianteEntity
	 * @return
	 */
	public static EstudianteDto entityToModel(EstudianteEntity estudianteEntity) {
		EstudianteDto estudiante = new EstudianteDto();
		estudiante.setDni(estudianteEntity.getDni());
		estudiante.setNombre(estudianteEntity.getNombre());
		estudiante.setApellido(estudianteEntity.getApellido());
		estudiante.setEdad(estudianteEntity.getEdad());
		estudiante.setGenero(estudianteEntity.getGenero());
		estudiante.setCiudad(estudianteEntity.getCiudad());
		estudiante.setNroLibretaUnica(estudianteEntity.getNroLibretaUnica());
		return estudiante;
	}

	/**
	 * 
	 * @param estudiante
	 * @return
	 */
	public static EstudianteEntity modelToEntity(EstudianteDto estudiante) {
		EstudianteEntity estudianteEntity = new EstudianteEntity();
		estudianteEntity.setDni(estudiante.getDni());
		estudianteEntity.setNombre(estudiante.getNombre());
		estudianteEntity.setApellido(estudiante.getApellido());
		estudianteEntity.setEdad(estudiante.getEdad());
		estudianteEntity.setGenero(estudiante.getGenero());
		estudianteEntity.setCiudad(estudiante.getCiudad());
		estudianteEntity.setNroLibretaUnica(estudiante.getNroLibretaUnica());
		return estudianteEntity;
	}

	/**
	 * 
	 * @param estudianteEntities
	 * @return
	 */
	public static List<EstudianteDto> entityListToModelList(List<EstudianteEntity> estudianteEntities) {
		List<EstudianteDto> estudiantes = new ArrayList<>();
		for (EstudianteEntity estudianteEntity : estudianteEntities) {
			estudiantes.add(entityToModel(estudianteEntity));
		}
		return estudiantes;
	}

	/**
	 * 
	 * @param estudiantes
	 * @return
	 */
	public static List<EstudianteEntity> modelListToEntityList(List<EstudianteDto> estudiantes) {
		List<EstudianteEntity> estudianteEntities = new ArrayList<>();
		for (EstudianteDto estudiante : estudiantes) {
			estudianteEntities.add(modelToEntity(estudiante));
		}
		return estudianteEntities;
	}
}
