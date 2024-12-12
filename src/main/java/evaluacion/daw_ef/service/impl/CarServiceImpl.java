package evaluacion.daw_ef.service.impl;

import evaluacion.daw_ef.entity.Car;
import evaluacion.daw_ef.repository.CarRepository;
import evaluacion.daw_ef.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    // Inyección de dependencias mediante el constructor
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Optional<Car> findById(Integer id) {
        return carRepository.findById(id);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void deleteById(Integer id) {
        carRepository.deleteById(id);
    }
}
