package br.unicesumar.adsis4s2021.DioneADS2021.minhaBase;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class MeuExceptionManager {

	@ExceptionHandler({MeuNotFoundException.class})
	public ResponseEntity<MeuExceptionDTO> handleNotFoundException(Throwable exception) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MeuExceptionDTO(exception.getClass().getName(), exception.getMessage()));
	}

	@ExceptionHandler({MeuBadRequestException.class})
	public ResponseEntity<MeuExceptionDTO> handleBadRequestException(Throwable exception) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MeuExceptionDTO(exception.getClass().getName(), exception.getMessage()));
	}
}
