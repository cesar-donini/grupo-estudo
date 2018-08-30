package com.user.user.dto.response;

import lombok.Data;

@Data
public class UserResponse {

	private int id;
	private String name;
	private String lastName;
	private String registerCode;

	public UserResponse() {
		super();
	}

	public UserResponse(int id, String name, String lastName, String registerCode) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.registerCode = registerCode;
	}

	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", name=" + name + ", lastName=" + lastName + ", registerCode=" + registerCode
				+ "]";
	}

}
