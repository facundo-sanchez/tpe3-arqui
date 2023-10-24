package tpe3.arquitectura.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tpe3.arquitectura.models.Estudiante;

@RestController
@RequestMapping("/estudiante")
public class EstudianteController {
	@GetMapping
	public ResponseEntity<?> getAllEstudiante() {
		Map<String, Object> response = new HashMap<>();
		try {
			List<Estudiante> estudiantes = new ArrayList<Estudiante>();

			return new ResponseEntity<List<Estudiante>>(estudiantes,HttpStatus.OK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
