package com.baby.demo.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.baby.demo.controller.ProductController;

import lombok.Data;

@Data
public class ProductRequestPost {
	
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
	
	public ProductRequestPost() {
		Integer count = 0;
		if (ProductController.ListProduct.getListProduct().size() > 0) {
			count = ProductController.ListProduct.getListProduct().get(ProductController.ListProduct.getListProduct().size()-1).getId();
		}
		this.id = count+1;
	}
	
}
