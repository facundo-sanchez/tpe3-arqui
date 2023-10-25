package tpe3.arquitectura.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tpe3.arquitectura.entities.CarreraEntity;

@Repository
public interface CarreraRepository extends JpaRepository<CarreraEntity, Long> {

}
