package evaluacion.daw_ef.controller;

import evaluacion.daw_ef.entity.Car;
import evaluacion.daw_ef.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = carService.findAll();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        Optional<Car> car = carService.findById(id);
        return car.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car savedCar = carService.save(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCar);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer id, @RequestBody Car carDetails) {
        Optional<Car> carOptional = carService.findById(id);
        if (carOptional.isPresent()) {
            Car car = carOptional.get();
            car.setMake(carDetails.getMake());
            car.setModel(carDetails.getModel());
            car.setYear(carDetails.getYear());
            car.setVin(carDetails.getVin());
            car.setLicensePlate(carDetails.getLicensePlate());
            car.setOwnerName(carDetails.getOwnerName());
            car.setOwnerContact(carDetails.getOwnerContact());
            car.setPurchaseDate(carDetails.getPurchaseDate());
            car.setMileage(carDetails.getMileage());
            car.setEngineType(carDetails.getEngineType());
            car.setColor(carDetails.getColor());
            car.setInsuranceCompany(carDetails.getInsuranceCompany());
            car.setInsurancePolicyNumber(carDetails.getInsurancePolicyNumber());
            car.setRegistrationExpirationDate(carDetails.getRegistrationExpirationDate());
            car.setServiceDueDate(carDetails.getServiceDueDate());
            Car updatedCar = carService.save(car);
            return ResponseEntity.ok(updatedCar);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Integer id) {
        if (carService.findById(id).isPresent()) {
            carService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
