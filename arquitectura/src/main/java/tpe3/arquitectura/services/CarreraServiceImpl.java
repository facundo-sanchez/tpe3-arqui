package tpe3.arquitectura.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tpe3.arquitectura.repository.CarreraRepository;

@Service
public class CarreraServiceImpl {

	@Autowired
	private CarreraRepository carreraRepository;
}
