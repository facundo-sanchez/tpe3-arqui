package tpe3.arquitectura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tpe3.arquitectura.entities.EstudianteCarreraEntity;
import tpe3.arquitectura.entities.EstudianteEntity;

@Repository
public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarreraEntity, Long>{
	
//	@Query("SELECT e FROM EstudianteCarreraEntity ce JOIN ce.estudiante e JOIN ce.carrera c WHERE e.ciudad = :ciudad AND c.nombre = :nombreCarrera")
//	List<EstudianteEntity> getEstudianteByCarreraAndCiudad(@Param("nombreCarrera") String nombreCarrera, @Param("ciudad") String ciudad);

}
