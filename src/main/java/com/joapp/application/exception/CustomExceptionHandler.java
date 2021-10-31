package com.joapp.application.exception;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.joapp.dto.response.ErrorMessageResponseDTO;



@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomExceptionHandler {
	private static final Logger LOG = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(ProcessException.class)
	@ResponseBody
	public ErrorMessageResponseDTO handleCustom(Exception exception) {

		LOG.error(exception.getMessage(), exception);

		ErrorMessageResponseDTO errorMessageResponseDTO = new ErrorMessageResponseDTO();
		errorMessageResponseDTO.setMessage(exception.getLocalizedMessage());

		return errorMessageResponseDTO;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ErrorMessageResponseDTO handleAll(ConstraintViolationException exception) {

		ErrorMessageResponseDTO errorMessageResponseDTO = new ErrorMessageResponseDTO();
		exception.getConstraintViolations().stream().findFirst().ifPresent(constraintViolation -> {
			LOG.error(constraintViolation.getMessage());
			errorMessageResponseDTO.setMessage(constraintViolation.getMessage());
		});

		return errorMessageResponseDTO;
	}

	@ExceptionHandler(Exception.class)
	public HttpServletResponse handleAll(Exception exception, HttpServletResponse response) {

		LOG.error(exception.getMessage(), exception);
		return response;
	}
}
