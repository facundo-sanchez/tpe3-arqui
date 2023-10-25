package tpe3.arquitectura.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpe3.arquitectura.dto.EstudianteDto;
import tpe3.arquitectura.entities.EstudianteEntity;
import tpe3.arquitectura.mappers.EstudianteMapper;
import tpe3.arquitectura.repository.EstudianteRepository;

@Service
public class EstudianteServiceImpl implements EstudianteService {

	@Autowired
	private EstudianteRepository estudianteRepository;

	@Override
	public List<EstudianteDto> findAll(String order, String genero) {
		List<EstudianteEntity> result = this.estudianteRepository.findEstudiantesByGeneroOrOrder(order, genero);

		List<EstudianteDto> estudiantes = EstudianteMapper.entityListToModelList(result);
		return estudiantes;
	}

	@Override
	public EstudianteDto findById(Long id) {
		Optional<EstudianteEntity> result = this.estudianteRepository.findById(id);

		if (!result.isPresent())
			return null;

		EstudianteEntity estudiante = result.get();
		EstudianteDto response = EstudianteMapper.entityToModel(estudiante);
		return response;
	}

	@Override
	public EstudianteDto findByNroLibreta(int nroLibreta) {
		EstudianteEntity result = this.estudianteRepository.findByNroLibreta(nroLibreta);

		EstudianteDto estudiante = EstudianteMapper.entityToModel(result);

		return estudiante;
	}

	@Override
	public EstudianteDto save(EstudianteDto estudiante) {
		EstudianteEntity entity = new EstudianteEntity();

		entity = EstudianteMapper.modelToEntity(estudiante);

		EstudianteEntity result = this.estudianteRepository.save(entity);

		if (result == null)
			return null;

		return estudiante;
	}

	@Override
	public EstudianteDto delete(int id) {
		return null;
	}

}
