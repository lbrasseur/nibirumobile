package ar.com.oxen.nibiru.mobile.android.service.security;

import ar.com.oxen.nibiru.mobile.core.api.service.security.LoginDto;

public class LoginDtoImpl implements LoginDto {
	private String username;
	private String password;

	public LoginDtoImpl() {
		super();
	}

	public LoginDtoImpl(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
