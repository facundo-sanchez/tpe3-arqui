package tpe3.arquitectura.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tpe3.arquitectura.dto.RespuestaReporteCarreraDto;
import tpe3.arquitectura.entities.CarreraEntity;

@Repository
public interface CarreraRepository extends JpaRepository<CarreraEntity, Long> {

	@Query(nativeQuery = true, value = "SELECT ca.id, ca.nombre, ca.anio, "
			+ "SUM(CASE WHEN ca.anio = ec.inscripcion THEN 1 ELSE 0 END) AS inscriptos, "
			+ "SUM(CASE WHEN ca.anio = ec.graduacion THEN 1 ELSE 0 END) AS egresados " + "FROM ("
			+ "SELECT c.id, c.nombre, ec.inscripcion AS anio " + "FROM carreras c "
			+ "JOIN estudiantes_carreras ec ON c.id = ec.id_carrera " + "UNION " + "SELECT c.id, c.nombre, "
			+ "(CASE WHEN ec.graduacion = 0 THEN ec.inscripcion ELSE ec.graduacion END) AS anio " + "FROM carreras c "
			+ "JOIN estudiantes_carreras ec ON c.id = ec.id_carrera) ca "
			+ "LEFT JOIN estudiantes_carreras ec ON ca.id = ec.id_carrera " + "GROUP BY ca.id, ca.anio "
			+ "ORDER BY ca.nombre, ca.anio")
	List<Object[]> getReporteCarreras();

	@Query("SELECT c, COUNT(e) AS inscriptos FROM CarreraEntity c JOIN c.estudiantes e GROUP BY c ORDER BY inscriptos DESC")
	List<Object[]> getCarrerasConInscriptos();
}
