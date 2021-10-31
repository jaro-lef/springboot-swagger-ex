package com.joapp.dto.response;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ErrorMessageResponseDTO {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {

		return new ToStringBuilder(this).append("message", message).toString();
	}
}
