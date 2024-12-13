package br.com.linhaus.controle_estoque.resources.exceptions;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.linhaus.controle_estoque.services.exceptions.DatabaseException;
import br.com.linhaus.controle_estoque.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;

//Intercepta exceções que acontecem para que possa realizar o tratamento
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
		String error = "Database error";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> fieldValidation(ConstraintViolationException e, HttpServletRequest request) {
		String error = "Field validation error";
		HttpStatus status = HttpStatus.BAD_REQUEST;

		// Extraia apenas as mensagens das violações:
		List<String> messages = e.getConstraintViolations().stream().map(violation -> violation.getMessage())
				.collect(Collectors.toList());

		StandardError err = new StandardError(Instant.now(), status.value(), error, String.join(" ; ", messages),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
