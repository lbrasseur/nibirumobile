package ar.com.oxen.nibiru.mobile.security.java.service;

import ar.com.oxen.nibiru.mobile.security.core.api.service.UserDto;

public class UserDtoImpl implements UserDto {
	private String firstName;
	private String lastName;

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
