package tpe3.arquitectura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpe3.arquitectura.entities.EstudianteCarreraEntity;

@Repository
public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarreraEntity, Long> {

}
