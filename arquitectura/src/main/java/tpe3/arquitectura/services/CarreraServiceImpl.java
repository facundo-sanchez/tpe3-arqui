package tpe3.arquitectura.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpe3.arquitectura.dto.CarreraDto;
import tpe3.arquitectura.dto.RepuestaCarreraInscriptosDto;
import tpe3.arquitectura.dto.RespuestaReporteCarreraDto;
import tpe3.arquitectura.entities.CarreraEntity;
import tpe3.arquitectura.mappers.CarreraMapper;
import tpe3.arquitectura.repository.CarreraRepository;

@Service
public class CarreraServiceImpl implements CarreraService {

	@Autowired
	private CarreraRepository carreraRepository;

	@Override
	public CarreraDto findById(Long id) {
		try {
			Optional<CarreraEntity> result = this.carreraRepository.findById(id);
			if (!result.isPresent())
				return null;

			CarreraEntity carrera = result.get();
			CarreraDto response = CarreraMapper.entityToModel(carrera);

			return response;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<CarreraDto> findAll() {
		try {
			List<CarreraEntity> result = this.carreraRepository.findAll();

			return CarreraMapper.entityListToModelList(result);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public CarreraDto save(CarreraDto carrera) {
		try {
			CarreraEntity result = this.carreraRepository.save(CarreraMapper.modelToEntity(carrera));

			return CarreraMapper.entityToModel(result);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<RespuestaReporteCarreraDto> getReportesCarreras() {
		try {
			List<Object[]> result = this.carreraRepository.getReporteCarreras();
			return CarreraMapper.entityToModelRespuestaReporte(result);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<RepuestaCarreraInscriptosDto> getCarrerasConInscriptos() {
		try {
			List<Object[]> result = this.carreraRepository.getCarrerasConInscriptos();
			return CarreraMapper.entityToModelRespuesta(result);
		} catch (Exception e) {
			return null;
		}
	}

}
