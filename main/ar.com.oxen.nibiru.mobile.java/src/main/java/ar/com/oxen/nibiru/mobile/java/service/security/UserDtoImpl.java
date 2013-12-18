package ar.com.oxen.nibiru.mobile.java.service.security;

import ar.com.oxen.nibiru.mobile.core.api.service.security.UserDto;

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
