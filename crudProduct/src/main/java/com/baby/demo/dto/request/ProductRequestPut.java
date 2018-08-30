package com.baby.demo.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class ProductRequestPut {

	private Integer id;
	
	@NotEmpty
	@NotNull
	private String description;
	
	@NotEmpty
	@NotNull
	private String price;
	
	@NotEmpty
	@NotNull
	private String amount;
	
	private String type;
	private Integer provider;

}
