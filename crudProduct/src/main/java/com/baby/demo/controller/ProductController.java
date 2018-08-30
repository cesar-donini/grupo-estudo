package com.baby.demo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baby.demo.dto.Product;
import com.baby.demo.dto.request.ProductRequestPost;
import com.baby.demo.dto.request.ProductRequestPut;

@RestController
@RequestMapping("product")
public class ProductController {
	
	public static Product ListProduct = new Product();
	
	@PostMapping("")
	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequestPost productRequest) {
		ListProduct.setProduct(productRequest);
		return ResponseEntity.ok("Produto cadastrado com sucesso.");
	}
	
	@PutMapping("")
	public ResponseEntity<?> editProduct(@Valid @RequestBody ProductRequestPut productRequest) {
		ProductRequestPost updateProduct = ListProduct.get(productRequest.getId());
		if (updateProduct != null) {
		updateProduct.setAmount(productRequest.getAmount());
		updateProduct.setDescription(productRequest.getDescription());
		updateProduct.setPrice(productRequest.getPrice());
		updateProduct.setProvider(productRequest.getProvider());
		updateProduct.setType(productRequest.getType());
			return ResponseEntity.ok("Produto alterado com sucesso.");
		}
		
		return ResponseEntity.ok("Produto não encontrado.");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {		
		return ResponseEntity.ok(ListProduct.removeItem(id));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Integer id) {
		ProductRequestPost productRequest = ListProduct.get(id);
		if (productRequest != null)
			return ResponseEntity.ok(productRequest);
		
		return ResponseEntity.ok("Produto não encontrado");
	}
	
	@GetMapping("")
	public ResponseEntity<?> getAllProduct() {
		return ResponseEntity.ok(ListProduct.getListProduct());
	}
}
