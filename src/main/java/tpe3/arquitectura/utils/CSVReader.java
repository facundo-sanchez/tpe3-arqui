package tpe3.arquitectura.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import tpe3.arquitectura.dto.CarreraDto;
import tpe3.arquitectura.dto.EstudianteCarreraDto;
import tpe3.arquitectura.dto.EstudianteDto;

@Component
public class CSVReader {

	@SuppressWarnings("deprecation")
	public List<EstudianteDto> readEstudiantesFromCSV(String filePath) throws IOException {
		List<EstudianteDto> estudiantes = new ArrayList<EstudianteDto>();
		FileReader fileReader = new FileReader(filePath);

		try (CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader())) {
			for (CSVRecord record : csvParser) {
				long dni = Long.parseLong(record.get("DNI"));
				String nombre = record.get("nombre");
				String apellido = record.get("apellido");
				int edad = Integer.parseInt(record.get("edad"));
				String genero = record.get("genero");
				String ciudad = record.get("ciudad");
				int nroLibreta = Integer.parseInt(record.get("LU"));

				EstudianteDto estudiante = new EstudianteDto();
				estudiante.setDni(dni);
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setEdad(edad);
				estudiante.setGenero(genero);
				estudiante.setCiudad(ciudad);
				estudiante.setNroLibretaUnica(nroLibreta);

				estudiantes.add(estudiante);
			}
		}
		return estudiantes;
	}

	@SuppressWarnings("deprecation")
	public List<CarreraDto> readCarrerasFromCSV(String filePath) throws IOException {
		List<CarreraDto> carreras = new ArrayList<CarreraDto>();
		FileReader fileReader = new FileReader(filePath);

		try (CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader())) {
			for (CSVRecord record : csvParser) {
				long id = Long.parseLong(record.get("id_carrera"));
				String nombre = record.get("carrera");
				int duracion = Integer.parseInt(record.get("duracion"));

				CarreraDto carrera = new CarreraDto(nombre, duracion);
				carrera.setId(id);

				carreras.add(carrera);
			}
		}
		return carreras;
	}

	@SuppressWarnings("deprecation")
	public List<EstudianteCarreraDto> readEstudianteCarreraFromCSV(String filePath) throws IOException {
		List<EstudianteCarreraDto> estudianteCarreras = new ArrayList<EstudianteCarreraDto>();
		FileReader fileReader = new FileReader(filePath);

		try (CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withHeader())) {
			for (CSVRecord record : csvParser) {
				long id = Long.parseLong(record.get("id"));
				long idEstudiante = Long.parseLong(record.get("id_estudiante"));
				long idCarrera = Long.parseLong(record.get("id_carrera"));
				int inscripcion = Integer.parseInt(record.get("inscripcion"));
				int graduacion = Integer.parseInt(record.get("graduacion"));
				int antiguedad = Integer.parseInt(record.get("antiguedad"));

				EstudianteDto estudiante = new EstudianteDto();
				estudiante.setDni(idEstudiante);

				CarreraDto carrera = new CarreraDto();
				carrera.setId(idCarrera);

				EstudianteCarreraDto estudianteCarrera = new EstudianteCarreraDto();
				estudianteCarrera.setId(id);
				estudianteCarrera.setAnioInscripcion(inscripcion);
				estudianteCarrera.setAnioGraduacion(graduacion);
				estudianteCarrera.setAntiguedad(antiguedad);
				estudianteCarrera.setEstudiante(estudiante);
				estudianteCarrera.setCarrera(carrera);

				estudianteCarreras.add(estudianteCarrera);
			}
		}
		return estudianteCarreras;
	}
}
