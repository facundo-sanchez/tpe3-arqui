package tpe3.arquitectura.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import tpe3.arquitectura.dto.CarreraDto;
import tpe3.arquitectura.entities.CarreraEntity;


public class CarreraMapper {

	/**
	 * 
	 * @param carreraEntity
	 * @return
	 */
	public static CarreraDto entityToModel(CarreraEntity carreraEntity) {
		CarreraDto carrera = new CarreraDto();
		carrera.setId(carreraEntity.getId());
		carrera.setNombre(carreraEntity.getNombre());
		carrera.setDuracion(carreraEntity.getDuracion());
		return carrera;
	}

	/**
	 * 
	 * @param carrera
	 * @return
	 */
	public static CarreraEntity modelToEntity(CarreraDto carrera) {
		CarreraEntity carreraEntity = new CarreraEntity();
		carreraEntity.setId(carrera.getId());
		carreraEntity.setNombre(carrera.getNombre());
		carreraEntity.setDuracion(carrera.getDuracion());
		return carreraEntity;
	}

	/**
	 * 
	 * @param carreraEntities
	 * @return
	 */
	public static List<CarreraDto> entityListToModelList(List<CarreraEntity> carreraEntities) {
		List<CarreraDto> carreras = new ArrayList<CarreraDto>();
		for (CarreraEntity carreraEntity : carreraEntities) {
			carreras.add(entityToModel(carreraEntity));
		}
		return carreras;
	}

	/**
	 * 
	 * @param carreras
	 * @return
	 */
	public static List<CarreraEntity> modelListToEntityList(List<CarreraDto> carreras) {
		List<CarreraEntity> carreraEntities = new ArrayList<CarreraEntity>();
		for (CarreraDto carrera : carreras) {
			carreraEntities.add(modelToEntity(carrera));
		}
		return carreraEntities;
	}

	/**
	 * 
	 * @param carreraInscriptos
	 * @return
	 */
//	public static List<RepuestaCarreraInscriptos> entityToModelRespuesta(List<Object[]> carreraInscriptos) {
//		List<RepuestaCarreraInscriptos> respuestaInscriptos = new ArrayList<>();
//		for (Object[] row : carreraInscriptos) {
//			CarreraEntity carreraEntity = (CarreraEntity) row[0];
//			Long inscriptos = (Long) row[1];
//			RepuestaCarreraInscriptos respuesta = new RepuestaCarreraInscriptos();
//			respuesta.setCarrera(entityToModel(carreraEntity));
//			respuesta.setInscriptos(inscriptos.intValue());
//			respuestaInscriptos.add(respuesta);
//		}
//		return respuestaInscriptos;
//	}
//
//	/**
//	 * 
//	 * @param carreraReporte
//	 * @return
//	 */
//	public static List<RespuestaReporteCarrera> entityToModelRespuestaReporte(List<Object[]> carreraReporte) {
//		List<RespuestaReporteCarrera> resultadoFinal = new ArrayList<>();
//
//		for (Object[] resultado : carreraReporte) {
//			String nombreCarrera = (String) resultado[1];
//			int id = (int) resultado[0];
//			int anio = (int) resultado[2];
//			BigDecimal inscriptos = (BigDecimal) resultado[3];
//			BigDecimal egresados = (BigDecimal) resultado[4];
//
//			RespuestaReporteCarrera respuestaCarrera = null;
//
//			for (RespuestaReporteCarrera carrera : resultadoFinal) {
//				if (carrera.getCarrera().getNombre().equals(nombreCarrera)) {
//					respuestaCarrera = carrera;
//					break;
//				}
//			}
//
//			if (respuestaCarrera == null) {
//				respuestaCarrera = new RespuestaReporteCarrera();
//				Carrera carrera = new Carrera();
//				carrera.setId(id);
//				carrera.setNombre(nombreCarrera);
//				respuestaCarrera.setCarrera(carrera);
//				resultadoFinal.add(respuestaCarrera);
//			}
//
//			ReporteCarrera reporteCarrera = new ReporteCarrera();
//			reporteCarrera.setAnio(anio);
//			reporteCarrera.setInscriptos(inscriptos.intValue());
//			reporteCarrera.setEgresados(egresados.intValue());
//			respuestaCarrera.getReporteCarrera().add(reporteCarrera);
//		}
//
//		return resultadoFinal;
//	}
}
