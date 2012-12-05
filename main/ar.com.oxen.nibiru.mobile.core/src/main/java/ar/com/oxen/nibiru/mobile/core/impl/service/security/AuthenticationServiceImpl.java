package ar.com.oxen.nibiru.mobile.core.impl.service.security;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;
import ar.com.oxen.nibiru.mobile.core.api.service.security.AuthenticationService;
import ar.com.oxen.nibiru.mobile.core.api.service.security.LoginDto;
import ar.com.oxen.nibiru.mobile.core.api.service.security.UserDto;

public class AuthenticationServiceImpl implements AuthenticationService {
	private RemoteService service;
	private Provider<LoginDto> loginDtoFactory;

	@Inject
	public AuthenticationServiceImpl(@Authentication RemoteService service,
			Provider<LoginDto> loginDtoFactory) {
		super();
		this.service = service;
		this.loginDtoFactory = loginDtoFactory;
	}

	@Override
	public void login(String username, String password,
			Callback<UserDto> callback) {
		LoginDto loginDto = this.loginDtoFactory.get();
		loginDto.setUsername(username);
		loginDto.setPassword(password);
		service.invoke("login", loginDto, UserDto.class, callback);
	}
}
