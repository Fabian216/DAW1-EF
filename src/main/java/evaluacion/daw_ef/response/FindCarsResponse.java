package evaluacion.daw_ef.response;

import evaluacion.daw_ef.dto.CarDto;

import java.util.List;

public record FindCarsResponse(String code, String message, List<CarDto> cars) {
}
