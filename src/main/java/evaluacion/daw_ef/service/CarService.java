package evaluacion.daw_ef.service;

import evaluacion.daw_ef.dto.CarDto;
import evaluacion.daw_ef.dto.CardCreateDto;
import evaluacion.daw_ef.dto.CardDetailDto;

import java.util.List;
import java.util.Optional;

public interface CarService {

    List<CarDto> findAll() throws Exception;
    Optional<CarDto> findAllOrById(int id) throws Exception;
    Optional<CardDetailDto> findById(Integer id) throws Exception;
    boolean updateCar(CardDetailDto cardDetailDto) throws Exception;
    boolean deleteCar(int id) throws Exception;
    boolean createCar(CardCreateDto cardCreateDto) throws Exception;

}
