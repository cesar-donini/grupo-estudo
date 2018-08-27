package com.example.demo.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class HomeRequest {

	private String name;
	
	@NotEmpty
	@NotNull
	private String idade;
	
	private String profissao;
	
	private String xunda;
	
	private String hidalgo;

	
}
