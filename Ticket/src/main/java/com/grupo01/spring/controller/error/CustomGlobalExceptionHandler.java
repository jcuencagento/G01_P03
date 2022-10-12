package com.grupo01.spring.controller.error;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
Add one class extending ResponseEntityExceptionHandler and annotate it with @ControllerAdvice annotation.

ResponseEntityExceptionHandler is a convenient base class for to provide centralized exception
handling across all @RequestMapping methods through @ExceptionHandler methods. 
@ControllerAdvice is more for enabling auto-scanning and configuration at application startup.

si usas ResponseEntityExceptionHandler tienes un logger embebido

*/

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// Let Spring BasicErrorController handle the exception, we just override the status code
	// Otra opción es hacerlo de forma individual, pero asi aglutinamos todos y
	// podemos dar incluso distintos valores o acciones

	// @ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(TicketNotFoundException.class)
	public void springHandleNotFound(HttpServletResponse response) throws IOException {
		logger.info("------ MovieNotFoundException() ");
		// Saltará a la clase CustomErrorAttibuttes para crear un error personalizado
		response.sendError(HttpStatus.NOT_FOUND.value());
	}

	/*
	// @Validate For Validating Path Variables and Request Parameters
	@ExceptionHandler(EventNullException.class)
	public void constraintViolationException(HttpServletResponse response) throws IOException {
		logger.info("------ EventNullException() ");
		response.sendError(HttpStatus.BAD_REQUEST.value());
	}
	*/

	// error handle for @Valid
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		logger.info("------ handleMethodArgumentNotValid()");
		
		CustomErrorJson customError = new CustomErrorJson();

		//Paso fecha pero la formatea a String con formato DD/MM/YY
		customError.setTimestamp(new Date());
		//customError.setTrace(ex.getLocalizedMessage());
		customError.setStatus(status.value());
		customError.setError(status.name());
		
		// Get all errors indicando el campo en el que falla
		List<String> messages = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			messages.add(error.getField() + ": " + error.getDefaultMessage());
		}
		customError.setMessage(messages);
		
		//Para recoger el path y simular de forma completa los datos originales
		// request.getDescription(false) ---> uri=/students
		String uri = request.getDescription(false);
		uri = uri.substring(uri.lastIndexOf("=")+1);
		customError.setPath(uri);

		return new ResponseEntity<>(customError, headers, status);

	}

	
	// A este método se llama cuando se haga una peticion no existente, or ejemplo,
	// una URI de tipo GET que se haga con POST
	// En este caso uso no uso la clase personalziada de errores para ver como se haría en ese caso
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		logger.info("------ handleHttpRequestMethodNotSupported()");
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getMethod());
		builder.append(" method is not supported for this request. Supported methods are ");
		ex.getSupportedHttpMethods().forEach(t -> builder.append(t + " "));

		Map<String, Object> body = new LinkedHashMap<>();
		// Paso fecha formateada a String
		body.put("timestamp", new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date()));
		body.put("status", status.value());
		body.put("error", ex.getLocalizedMessage());
		body.put("message", builder.toString());

		return new ResponseEntity<Object>(body, new HttpHeaders(), HttpStatus.METHOD_NOT_ALLOWED);

	}

}
