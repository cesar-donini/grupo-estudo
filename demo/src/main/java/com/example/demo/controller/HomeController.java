package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.param.HomeParam;
import com.example.demo.dto.request.HomeRequest;

@RestController
@RequestMapping("home")
public class HomeController {

	@GetMapping("teste")
	public ResponseEntity<?> get() {
		return ResponseEntity.ok("OK");
	}
	
	@GetMapping("teste2")
	public ResponseEntity<?> get2(@RequestParam(required = true) String name) {
		return ResponseEntity.ok(name);
	}
	
	@GetMapping("teste3/{teste421}")
	public ResponseEntity<?> get3(@PathVariable("teste421") String name) {
		return ResponseEntity.ok(name);
	}
	
	@GetMapping("teste4")
	public ResponseEntity<?> get4(@Valid HomeParam homeParam) {
		return ResponseEntity.ok(homeParam);
	}
	
	@PostMapping("teste5")
	public ResponseEntity<?> post5(@Valid @RequestBody HomeRequest homeRequest) {
		return ResponseEntity.ok(homeRequest);
	}
	
	@DeleteMapping("/{name}")
	public ResponseEntity<?> delete(@PathVariable String name) {
		return ResponseEntity.ok(name);
	}
	
}
