package tpe3.arquitectura.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tpe3.arquitectura.dto.EstudianteCarreraDto;
import tpe3.arquitectura.dto.EstudianteDto;
import tpe3.arquitectura.services.EstudianteCarreraServiceImpl;
import tpe3.arquitectura.services.EstudianteServiceImpl;

@RestController
@RequestMapping("estudiante")
public class EstudianteController {

	@Autowired
	private EstudianteServiceImpl estudianteService;

	@Autowired
	private EstudianteCarreraServiceImpl estudianteCarreraService;

	@PostMapping
	public ResponseEntity<?> addEstudiante(@RequestBody EstudianteDto estudiante) {
		Map<String, Object> response = new HashMap<>();
		try {
			EstudianteDto result = this.estudianteService.save(estudiante);
			if (result == null) {
				response.put("message", "Hubo un error al crear el estudiante");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<EstudianteDto>(result, HttpStatus.CREATED);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// http://localhost:8080/estudiante?order=asc&genero=masculino
	@GetMapping
	public ResponseEntity<?> getEstudiantes(@RequestParam(name = "order", required = false) String order,
			@RequestParam(name = "genero", required = false) String genero) {
		Map<String, Object> response = new HashMap<>();
		try {
			List<EstudianteDto> estudiantes = new ArrayList<EstudianteDto>();
			
			if(order == null) {
				order = "asc";
			}
			if(genero == null) {
				genero = "";
			}
			
			estudiantes = this.estudianteService.findAll(order, genero);

			return new ResponseEntity<List<EstudianteDto>>(estudiantes, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getEstudianteById(@PathVariable Long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			EstudianteDto result = this.estudianteService.findById(id);

			if (result == null) {
				response.put("mensaje", "No se encontro el usuario con el id " + id);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<EstudianteDto>(result, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("message", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("nroLibreta/{nroLibreta}")
	public ResponseEntity<?> getEstudianteByNroLibreta(@PathVariable int nroLibreta) {
		Map<String, Object> response = new HashMap<>();
		try {
			EstudianteDto result = this.estudianteService.findByNroLibreta(nroLibreta);

			if (result == null) {
				response.put("message", "No se encontro el usuario con numero de libreta " + nroLibreta);
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<EstudianteDto>(result, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/matricular")
	public ResponseEntity<?> matricularEstudiante(@RequestBody EstudianteCarreraDto estudianteCarrera) {
		Map<String, Object> response = new HashMap<>();
		try {
			EstudianteCarreraDto result = this.estudianteCarreraService.matricularEstudiante(estudianteCarrera);

			if (result == null) {
				response.put("message", "Hubo un error al matricular el estudiante");
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
			}

			return new ResponseEntity<EstudianteCarreraDto>(result, HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
