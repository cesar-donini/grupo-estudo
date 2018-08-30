package com.user.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.user.dao.impl.IUserDAO;
import com.user.user.dto.request.UserRequest;
import com.user.user.dto.response.UserResponse;
import com.user.user.service.impl.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDao;

	@Override
	public UserResponse save(UserRequest userRequest) {
		return userDao.save(userRequest);
	}

	@Override
	public UserResponse edit(UserRequest userRequest) {
		return userDao.edit(userRequest);
	}

	@Override
	public List<UserResponse> getAll() {
		return userDao.getAll();
	}

	@Override
	public UserResponse getByName(String name) {
		return userDao.getByName(name);
	}

	@Override
	public UserResponse getById(int id) {
		return userDao.getById(id);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

}
