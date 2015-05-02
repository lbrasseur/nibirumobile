package ar.com.oxen.nibiru.mobile.security.java.service;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.security.core.api.service.LoginDto;

public class LoginDtoImpl implements LoginDto {
	private String username;
	private String password;

	public LoginDtoImpl() {
	}

	public LoginDtoImpl(String username, String password) {
		this.username = checkNotNull(username);
		this.password = checkNotNull(password);
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}
}
