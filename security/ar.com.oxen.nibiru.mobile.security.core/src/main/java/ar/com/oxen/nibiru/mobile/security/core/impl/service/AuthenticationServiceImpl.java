package ar.com.oxen.nibiru.mobile.security.core.impl.service;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;
import ar.com.oxen.nibiru.mobile.security.core.api.service.AuthenticationService;
import ar.com.oxen.nibiru.mobile.security.core.api.service.LoginDto;
import ar.com.oxen.nibiru.mobile.security.core.api.service.UserDto;

public class AuthenticationServiceImpl implements AuthenticationService {
	private final RemoteService service;
	private final Provider<LoginDto> loginDtoFactory;

	@Inject
	public AuthenticationServiceImpl(@Authentication RemoteService service,
			Provider<LoginDto> loginDtoFactory) {
		this.service = checkNotNull(service);
		this.loginDtoFactory = checkNotNull(loginDtoFactory);
	}

	@Override
	public void login(String username, String password,
			Callback<UserDto> callback) {
		LoginDto loginDto = loginDtoFactory.get();
		loginDto.setUsername(username);
		loginDto.setPassword(password);
		service.invoke("login", loginDto, UserDto.class, callback);
	}
}
