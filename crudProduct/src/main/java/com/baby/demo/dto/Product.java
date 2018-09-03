package com.baby.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.baby.demo.dto.request.ProductRequestPost;

import lombok.Data;

@Data
public class Product {
	
	private List<ProductRequestPost>listProduct;
	
	public Product() {
		super();
		this.listProduct = new ArrayList<ProductRequestPost>();
	}

	public void setProduct(ProductRequestPost productRequest) {
		this.listProduct.add(productRequest);
	}
	
	public String removeItem(Integer id) {
		int initialSize = listProduct.size();		
		this.listProduct.removeIf(i -> i.getId().equals(id));
		
		if (initialSize == listProduct.size()) {
			return "Produto não encontrado";
		}
		
		return "Produto deletado com sucesso.";
	}
	
	public ProductRequestPost get(Integer id) {
		return this.listProduct.stream()
						.filter(product -> product.getId().equals(id))
						.findFirst()
						.orElse(null);
	}
	
}
