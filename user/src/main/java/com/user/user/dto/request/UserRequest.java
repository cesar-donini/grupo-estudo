package com.user.user.dto.request;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserRequest {

	private int id;

	@NotEmpty
	@NotNull
	private String name;
	
	@NotEmpty
	@NotNull
	private String lastName;
	
	private String registerCode;

	@Override
	public String toString() {
		return "UserRequest [id=" + id + ", name=" + name + ", lastName=" + lastName + ", registerCode=" + registerCode
				+ "]";
	}

}
