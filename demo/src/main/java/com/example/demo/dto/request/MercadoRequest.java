package com.example.demo.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class MercadoRequest {
	
	@NotEmpty
	@NotNull
	private String id;
	
	@NotEmpty
	@NotNull
	private String nome;
	
	@NotEmpty
	@NotNull
	private String razaoSocial;
	
	@NotEmpty
	@NotNull
	private String CNPJ;
	
	
	private String grupo;
	
	@NotEmpty
	@NotNull
	private String endereco;
	
	@NotEmpty
	@NotNull
	private String telefone;
	
	@NotEmpty
	@NotNull
	private String email;
	
	private String numeroFilial;

	
}
