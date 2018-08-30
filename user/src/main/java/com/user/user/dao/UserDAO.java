package com.user.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.user.user.dao.impl.IUserDAO;
import com.user.user.dto.request.UserRequest;
import com.user.user.dto.response.UserResponse;

@Repository
public class UserDAO implements IUserDAO {

	private List<UserResponse> users = getUsers();

	@Override
	public UserResponse save(UserRequest userRequest) {
		UserResponse response = new UserResponse();
		response.setName(userRequest.getName());
		response.setLastName(userRequest.getLastName());
		response.setRegisterCode(userRequest.getRegisterCode());
		response.setId(users.size() + 1);
		users.add(response);

		return response;
	}
	
	@Override
	public UserResponse edit(UserRequest userRequest) {
		for (UserResponse user : users) {
			if (user.getId() == userRequest.getId()) {
				user.setName(userRequest.getName());
				user.setLastName(userRequest.getLastName());
				user.setRegisterCode(userRequest.getRegisterCode());
			}
		}
		return getById(userRequest.getId());
	}

	@Override
	public List<UserResponse> getAll() {
		return users;
	}

	@Override
	public UserResponse getByName(String name) {
		return users.stream()
				.filter(user -> user.getName().toLowerCase().contains(name.toLowerCase()))
				.findAny()
				.orElse(new UserResponse());
	}

	@Override
	public UserResponse getById(int id) {
		return users.stream()
				.filter(user -> user.getId() == id)
				.findAny()
				.orElse(new UserResponse());
	}

	@Override
	public void delete(int id) {
		users.removeIf(item -> item.getId() == id);
	}

	private List<UserResponse> getUsers() {
		List<UserResponse> users = new ArrayList<>();
		users.add(new UserResponse(1, "Cesar", "Donini", "11111"));
		users.add(new UserResponse(2, "Diogo", "Sonsim", "22222"));
		users.add(new UserResponse(3, "Luis", "Carvalho", "33333"));
		users.add(new UserResponse(4, "Thiago", "Tersariol", "44444"));
		users.add(new UserResponse(5, "João", "Tristão", "55555"));
		return users;
	}

}
