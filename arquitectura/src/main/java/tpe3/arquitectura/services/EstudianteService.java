package tpe3.arquitectura.services;

import java.util.List;

import tpe3.arquitectura.dto.EstudianteDto;

public interface EstudianteService {

	public List<EstudianteDto> findAll(String order, String genero);

	public EstudianteDto findById(Long id);

	public EstudianteDto findByNroLibreta(int nroLibreta);

	public EstudianteDto save(EstudianteDto estudiante);

	public EstudianteDto delete(int id);

}
