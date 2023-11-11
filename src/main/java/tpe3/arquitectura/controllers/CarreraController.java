package tpe3.arquitectura.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpe3.arquitectura.dto.CarreraDto;
import tpe3.arquitectura.dto.RepuestaCarreraInscriptosDto;
import tpe3.arquitectura.dto.RespuestaReporteCarreraDto;
import tpe3.arquitectura.services.CarreraService;

@RestController
@RequestMapping("carrera")
public class CarreraController {

	@Autowired
	private CarreraService carreraService;

	@PostMapping
	public ResponseEntity<?> addCarrera(@RequestBody CarreraDto carrera) {
		Map<String, Object> response = new HashMap<>();
		try {
			CarreraDto result = this.carreraService.save(carrera);
			if (result == null) {
				response.put("message", "Hubo un error al crear la carrera");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<CarreraDto>(result, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping
	public ResponseEntity<?> getCarreras() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<CarreraDto> result = this.carreraService.findAll();

			response.put("total", result.size());
			response.put("carreras", result);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getCarrera(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			CarreraDto result = this.carreraService.findById(id);
			if (result == null) {
				response.put("message", "Hubo un error al obtener la carrera con el id " + id);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<CarreraDto>(result, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/inscriptos")
	public ResponseEntity<?> getCarrerasConInscriptos() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<RepuestaCarreraInscriptosDto> result = this.carreraService.getCarrerasConInscriptos();
			if (result == null) {
				response.put("message", "Hubo un al obtener las carreras con inscriptos");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}

			response.put("total", result.size());
			response.put("carreraInscriptos", result);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/reportes")
	public ResponseEntity<?> getReporteCarreras() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<RespuestaReporteCarreraDto> result = this.carreraService.getReportesCarreras();
			if (result == null) {
				response.put("message", "Hubo un error al generar el reporte de carreras");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}

			response.put("total", result.size());
			response.put("reporteCarrera", result);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
