package com.user.user.service.impl;

import java.util.List;

import com.user.user.dto.request.UserRequest;
import com.user.user.dto.response.UserResponse;

public interface IUserService {

	public UserResponse save(UserRequest userRequest);

	public UserResponse edit(UserRequest userRequest);

	public List<UserResponse> getAll();

	public UserResponse getByName(String name);

	public UserResponse getById(int id);

	public void delete(int id);


}
