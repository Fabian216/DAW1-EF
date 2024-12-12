package evaluacion.daw_ef.controller;

import evaluacion.daw_ef.dto.CarDto;
import evaluacion.daw_ef.dto.CardCreateDto;
import evaluacion.daw_ef.dto.CardDetailDto;
import evaluacion.daw_ef.response.*;
import evaluacion.daw_ef.service.CarService;
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

    @GetMapping("/all")
    public FindCarsResponse findCars(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CarDto> optional = carService.findAllOrById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CarDto carDto = optional.get();
                    return new FindCarsResponse("01", "", List.of(carDto));
                } else {
                    return new FindCarsResponse("02", "Car no encontrado", null);
                }
            } else {
                List<CarDto> cars = carService.findAll();
                if (!cars.isEmpty()) {
                    return new FindCarsResponse("01", "", cars);
                } else {
                    return new FindCarsResponse("03", "lista de car no encontrada", cars);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "Solicitud mal empleada", null);
        }
    }

    @GetMapping("/detail")
    public FindCarByIdResponse findCarById(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CardDetailDto> optional = carService.findById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CardDetailDto carDetailDto = optional.get();
                    return new FindCarByIdResponse("01", "", carDetailDto);
                } else {
                    return new FindCarByIdResponse("02", "Car no encontrado", null);
                }
            } else {
                return new FindCarByIdResponse("03", "El id debe ser un entero", null);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarByIdResponse("99", "Solicitud mal empleada", null);
        }
    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CardCreateDto cardCreateDto) {
        try {
            boolean created = carService.createCar(cardCreateDto);
            if (created) {
                return new CreateCarResponse("01", "Car creado exitosamente");
            } else {
                return new CreateCarResponse("02", "Car no ha sido creado");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "Valores ingresados no validos");
        }
    }

    @PutMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CardDetailDto cardDetailDto) {
        try {
            boolean updated = carService.updateCar(cardDetailDto);
            if (updated) {
                return new UpdateCarResponse("01", "Car actualizado exitosamente");
            } else {
                return new UpdateCarResponse("02", "Fallo al actualizar el car");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "Valores no validos");
        }
    }

    @DeleteMapping("/delete")
    public DeleteCarResponse deleteCar(@RequestParam(value = "id") int id) {
        try {
            boolean deleted = carService.deleteCar(id);
            if (deleted) {
                return new DeleteCarResponse("01", "Car eliminado exitosamente");
            } else {
                return new DeleteCarResponse("02", "Fallo al eliminar el car");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "Valor ingresado no valido");
        }
    }

}
