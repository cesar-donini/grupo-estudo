package com.user.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.user.dto.request.UserRequest;
import com.user.user.dto.response.ApiErrorResponse;
import com.user.user.dto.response.UserResponse;
import com.user.user.service.impl.IUserService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUserService userService;

	@ApiResponses({
		@ApiResponse(code = 200, message = "Grava usuario", response = UserResponse.class),
		@ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = ApiErrorResponse.class)
	})
	@PostMapping
	public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest userRequest) {
		return ResponseEntity.ok(userService.save(userRequest));
	}
	
	
	@ApiResponses({
		@ApiResponse(code = 200, message = "Edita usuario", response = UserResponse.class),
		@ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = ApiErrorResponse.class)
	})
	@PutMapping
	public ResponseEntity<UserResponse> edit(@Valid @RequestBody UserRequest userRequest) {
		return ResponseEntity.ok(userService.edit(userRequest));
	}

	
	@ApiResponses({
		@ApiResponse(code = 200, message = "Recupera todos usuarios", response = UserResponse.class),
		@ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = ApiErrorResponse.class)
	})
	@GetMapping
	public ResponseEntity<List<UserResponse>> getAll() {
		return ResponseEntity.ok(userService.getAll());
	}

	
	@ApiResponses({
		@ApiResponse(code = 200, message = "Recupera usuario por nome", response = UserResponse.class),
		@ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = ApiErrorResponse.class)
	})
	@GetMapping(params = "name")
	public ResponseEntity<UserResponse> getByName(@RequestParam(required = true) String name) {
		return ResponseEntity.ok(userService.getByName(name));
	}

	
	@ApiResponses({
		@ApiResponse(code = 200, message = "Recupera usuario por id", response = UserResponse.class),
		@ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = ApiErrorResponse.class)
	})
	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> getById(@PathVariable("userId") int id) {
		return ResponseEntity.ok(userService.getById(id));
	}

	@ApiResponses({
		@ApiResponse(code = 200, message = "Deleta usuario por id", response = String.class),
		@ApiResponse(code = 400, message = "Bad Request", response = ApiErrorResponse.class),
		@ApiResponse(code = 500, message = "Internal Server Error", response = ApiErrorResponse.class)
	})
	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteById(@PathVariable("userId") int id) {
		userService.delete(id);
		return ResponseEntity.ok(String.format("O id %d foi deletado com sucesso.", id));
	}
}
