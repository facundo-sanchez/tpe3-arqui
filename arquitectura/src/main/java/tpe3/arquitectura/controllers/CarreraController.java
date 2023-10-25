package tpe3.arquitectura.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carrera")
public class CarreraController {
	
	@GetMapping
	public ResponseEntity<?> getCarreras(){
		try {
			return null;
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/estudiantes")
	public ResponseEntity<?> getCarrerasConInscriptos(){
		try {
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
