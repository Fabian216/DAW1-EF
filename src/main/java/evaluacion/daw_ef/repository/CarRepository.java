package evaluacion.daw_ef.repository;

import evaluacion.daw_ef.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
