package tpe3.arquitectura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tpe3.arquitectura.entities.EstudianteEntity;

@Repository
public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {

	@Query("SELECT e FROM EstudianteEntity e WHERE (e.genero LIKE :genero%) ORDER BY CASE WHEN :order = 'asc' THEN e.nombre END ASC, CASE WHEN :order = 'desc' THEN e.nombre END DESC")
	List<EstudianteEntity> findEstudiantesByGeneroOrOrder(@Param("order") String order, @Param("genero") String genero);

	@Query("SELECT e FROM EstudianteEntity e WHERE e.nroLibretaUnica = :nroLibreta")
	EstudianteEntity findByNroLibreta(@Param("nroLibreta") int nroLibreta);
	
	@Query("SELECT e FROM EstudianteCarreraEntity ce JOIN ce.estudiante e JOIN ce.carrera c WHERE e.ciudad = :ciudad AND c.nombre = :nombreCarrera")
	List<EstudianteEntity> getEstudianteByCarreraAndCiudad(@Param("nombreCarrera") String nombreCarrera, @Param("ciudad") String ciudad);


}
