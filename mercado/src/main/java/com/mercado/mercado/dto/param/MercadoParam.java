package com.mercado.mercado.dto.param;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class MercadoParam {
	
	private String id;

	@NotEmpty
	@NotNull
	private String nome;
	
	private String razaoSocial;
	
	private String CNPJ;
	
	private String grupo;
	
	private String endereco;
	
	private String telefone;
	
	private String email;
	
	private String numeroFilial;

}

