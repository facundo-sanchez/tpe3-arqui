package tpe3.arquitectura.mappers;

import java.util.ArrayList;
import java.util.List;

import tpe3.arquitectura.dto.EstudianteCarreraDto;
import tpe3.arquitectura.entities.EstudianteCarreraEntity;

public class EstudianteCarreraMapper {

	/**
	 * 
	 * @param entity
	 * @return
	 */
	public static EstudianteCarreraDto entityToModel(EstudianteCarreraEntity entity) {
		EstudianteCarreraDto model = new EstudianteCarreraDto();
		model.setId(entity.getId());
		model.setEstudiante(EstudianteMapper.entityToModel(entity.getEstudiante()));
		model.setCarrera(CarreraMapper.entityToModel(entity.getCarrera()));
		model.setAnioInscripcion(entity.getAnioInscripcion());
		model.setAnioGraduacion(entity.getAnioGraduacion());
		model.setAntiguedad(entity.getAntiguedad());
		return model;
	}

	/**
	 * 
	 * @param model
	 * @return
	 */
	public static EstudianteCarreraEntity modelToEntity(EstudianteCarreraDto model) {
		EstudianteCarreraEntity entity = new EstudianteCarreraEntity();
		entity.setId(model.getId());
		entity.setEstudiante(EstudianteMapper.modelToEntity(model.getEstudiante()));
		entity.setCarrera(CarreraMapper.modelToEntity(model.getCarrera()));
		entity.setAnioInscripcion(model.getAnioInscripcion());
		entity.setAnioGraduacion(model.getAnioGraduacion());
		entity.setAntiguedad(model.getAntiguedad());
		return entity;
	}

	/**
	 * 
	 * @param entities
	 * @return
	 */
	public static List<EstudianteCarreraDto> entityListToModelList(List<EstudianteCarreraEntity> entities) {
		List<EstudianteCarreraDto> models = new ArrayList<>();
		for (EstudianteCarreraEntity entity : entities) {
			models.add(entityToModel(entity));
		}
		return models;
	}

	/**
	 * 
	 * @param models
	 * @return
	 */
	public static List<EstudianteCarreraEntity> modelListToEntityList(List<EstudianteCarreraDto> models) {
		List<EstudianteCarreraEntity> entities = new ArrayList<>();
		for (EstudianteCarreraDto model : models) {
			entities.add(modelToEntity(model));
		}
		return entities;
	}
}
