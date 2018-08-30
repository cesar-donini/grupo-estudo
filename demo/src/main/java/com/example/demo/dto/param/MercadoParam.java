package com.example.demo.dto.param;

import lombok.Data;

@Data
public class MercadoParam {
	
	private String id;
	
	private String nome;
	
	private String razaoSocial;
	
	private String CNPJ;
	
	private String grupo;
	
	private String endereco;
	
	private String telefone;
	
	private String email;
	
	private String numeroFilial;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumeroFilial() {
		return numeroFilial;
	}

	public void setNumeroFilial(String numeroFilial) {
		this.numeroFilial = numeroFilial;
	}
	
	
}

