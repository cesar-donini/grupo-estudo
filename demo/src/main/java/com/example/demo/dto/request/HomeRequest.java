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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public String getXunda() {
		return xunda;
	}

	public void setXunda(String xunda) {
		this.xunda = xunda;
	}

	public String getHidalgo() {
		return hidalgo;
	}

	public void setHidalgo(String hidalgo) {
		this.hidalgo = hidalgo;
	}

	
	
	
}

