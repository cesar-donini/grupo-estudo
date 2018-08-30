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
		int[] count = {-1};
		if (this.listProduct.stream().peek(e -> count[0]++).filter(product -> product.getId().equals(id)).findFirst().orElse(null) != null) {
			this.listProduct.remove(count[0]);
			return "Produto deletado com sucesso.";
		}
		return "Produto não encontrado";
	}
	
	public ProductRequestPost get(Integer id) {
		return this.listProduct.stream().filter(product -> product.getId().equals(id)).findFirst().orElse(null);
	}

}
