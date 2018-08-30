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
import com.user.user.dto.response.UserResponse;
import com.user.user.service.impl.IUserService;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private IUserService userService;

	@PostMapping
	public ResponseEntity<UserResponse> save(@Valid @RequestBody UserRequest userRequest) {
		return ResponseEntity.ok(userService.save(userRequest));
	}
	
	@PutMapping
	public ResponseEntity<UserResponse> edit(@Valid @RequestBody UserRequest userRequest) {
		return ResponseEntity.ok(userService.edit(userRequest));
	}

	@GetMapping
	public ResponseEntity<List<UserResponse>> getAll() {
		return ResponseEntity.ok(userService.getAll());
	}

	@GetMapping(params = "name")
	public ResponseEntity<UserResponse> getByName(@RequestParam(required = true) String name) {
		return ResponseEntity.ok(userService.getByName(name));
	}

	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> getById(@PathVariable("userId") int id) {
		return ResponseEntity.ok(userService.getById(id));
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<String> deleteById(@PathVariable("userId") int id) {
		userService.delete(id);
		return ResponseEntity.ok(String.format("O id %d foi deletado com sucesso.", id));
	}

}
