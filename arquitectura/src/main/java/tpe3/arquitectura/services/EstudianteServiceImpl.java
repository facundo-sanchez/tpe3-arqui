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
		try {
			List<EstudianteEntity> result = this.estudianteRepository.findEstudiantesByGeneroOrOrder(order, genero);

			return EstudianteMapper.entityListToModelList(result);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public EstudianteDto findById(Long id) {
		try {
			Optional<EstudianteEntity> result = this.estudianteRepository.findById(id);

			if (!result.isPresent())
				return null;

			EstudianteEntity estudiante = result.get();

			return EstudianteMapper.entityToModel(estudiante);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public EstudianteDto findByNroLibreta(int nroLibreta) {
		try {
			EstudianteEntity result = this.estudianteRepository.findByNroLibreta(nroLibreta);

			return EstudianteMapper.entityToModel(result);
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public EstudianteDto save(EstudianteDto estudiante) {
		try {
			EstudianteEntity entity = new EstudianteEntity();

			entity = EstudianteMapper.modelToEntity(estudiante);

			EstudianteEntity result = this.estudianteRepository.save(entity);

			return EstudianteMapper.entityToModel(result);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public EstudianteDto delete(int id) {
		return null;
	}

}
