package com.example.demo.dto.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class HomeParam {

	@NotNull
	@NotEmpty
	private String nome;
	
	private String idade;
	
	private String profissao;
	
	private String xunda;
	
	private String hidalgo;

}