package evaluacion.daw_ef.response;

import evaluacion.daw_ef.dto.CardDetailDto;

public record FindCarByIdResponse(String code, String message, CardDetailDto car) {
}
