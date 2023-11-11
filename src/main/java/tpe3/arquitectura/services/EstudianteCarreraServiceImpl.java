package tpe3.arquitectura.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpe3.arquitectura.dto.EstudianteCarreraDto;
import tpe3.arquitectura.entities.EstudianteCarreraEntity;
import tpe3.arquitectura.mappers.EstudianteCarreraMapper;
import tpe3.arquitectura.repository.EstudianteCarreraRepository;

@Service
public class EstudianteCarreraServiceImpl implements EstudianteCarreraService {

	@Autowired
	private EstudianteCarreraRepository estudianteCarreraRepository;

	@Override
	public EstudianteCarreraDto matricularEstudiante(EstudianteCarreraDto estudianteCarrera) {
		try {
			EstudianteCarreraEntity response = this.estudianteCarreraRepository
					.save(EstudianteCarreraMapper.modelToEntity(estudianteCarrera));
			EstudianteCarreraDto result = EstudianteCarreraMapper.entityToModel(response);

			return result;
		} catch (Exception e) {
			return null;
		}
	}

}
