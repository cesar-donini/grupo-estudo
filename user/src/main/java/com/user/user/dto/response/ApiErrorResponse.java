package com.user.user.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Data
public class ApiErrorResponse {

	private LocalDateTime timestamp;

	private String message;
	
	private String exception;

	private ApiErrorResponse() {
		this.timestamp = LocalDateTime.now();
		this.message = "Unexpected error";
	}

	@Builder
	public ApiErrorResponse(String message, String exception) {
		this();
		this.message = message;
		this.exception = exception;
	}

}
