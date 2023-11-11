package tpe3.arquitectura;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tpe3.arquitectura.dto.CarreraDto;
import tpe3.arquitectura.dto.EstudianteCarreraDto;
import tpe3.arquitectura.dto.EstudianteDto;
import tpe3.arquitectura.services.CarreraService;
import tpe3.arquitectura.services.EstudianteCarreraService;
import tpe3.arquitectura.services.EstudianteService;
import tpe3.arquitectura.utils.CSVReader;

@Component
@SuppressWarnings("unused")
public class DatabaseInitializer {

	@Autowired
	private CarreraService carreraService;

	@Autowired
	private EstudianteService estudianteService;

	@Autowired
	private EstudianteCarreraService estudianteCarreraService;

	@PostConstruct
	public void insertData() {
		CSVReader csvReader = new CSVReader();
		try {
//			// Rutas a los archivos CSV
//			String carrerasCSVPath = "src/main/resources/csv/carreras.csv";
//			String estudiantesCSVPath = "src/main/resources/csv/estudiantes.csv";
//			String estudianteCarreraCSVPath = "src/main/resources/csv/estudianteCarrera.csv";
//
//			// Cargar los datos de los archivos CSV
//			List<CarreraDto> carreras = csvReader.readCarrerasFromCSV(carrerasCSVPath);
//			List<EstudianteDto> estudiantes = csvReader.readEstudiantesFromCSV(estudiantesCSVPath);
//			List<EstudianteCarreraDto> estudianteCarrera = csvReader
//					.readEstudianteCarreraFromCSV(estudianteCarreraCSVPath);
//
//			// Guardar los datos en la base de datos
//			System.out.println("Inicio de carga de datos.");
//			for (CarreraDto carrera : carreras) {
//				carreraService.save(carrera);
//			}
//			for (EstudianteDto estudiante : estudiantes) {
//				estudianteService.save(estudiante);
//			}
//			for (EstudianteCarreraDto estCarrera : estudianteCarrera) {
//				estudianteCarreraService.matricularEstudiante(estCarrera);
//			}
//			System.out.println("Datos cargados en la base de datos correctamente.");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error cargando datos en la base de datos");
		}
	}

}
