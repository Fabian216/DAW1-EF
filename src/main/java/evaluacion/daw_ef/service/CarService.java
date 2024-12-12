package evaluacion.daw_ef.service;

import evaluacion.daw_ef.entity.Car;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<Car> findAll(); // Obtener todos los coches
    Optional<Car> findById(Integer id); // Obtener un coche por su ID
    Car save(Car car); // Guardar o actualizar un coche
    void deleteById(Integer id); // Eliminar un coche por su ID

}
