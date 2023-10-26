package tpe3.arquitectura.services;

import java.util.List;

import tpe3.arquitectura.dto.CarreraDto;
import tpe3.arquitectura.dto.RepuestaCarreraInscriptosDto;
import tpe3.arquitectura.dto.RespuestaReporteCarreraDto;

public interface CarreraService {

	public CarreraDto findById(Long id);

	public List<CarreraDto> findAll();

	public CarreraDto save(CarreraDto carrera);

	public List<RespuestaReporteCarreraDto> getReportesCarreras();

	public List<RepuestaCarreraInscriptosDto> getCarrerasConInscriptos();
}
