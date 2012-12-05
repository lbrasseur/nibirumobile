package ar.com.oxen.nibiru.mobile.gwt.service.security;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.service.security.LoginDto;

public class AutoBeanLoginDtoProvider implements Provider<LoginDto> {
	private AutoBeanDtoFactory dtoFactory;

	@Inject
	public AutoBeanLoginDtoProvider(AutoBeanDtoFactory dtoFactory) {
		super();
		this.dtoFactory = dtoFactory;
	}

	@Override
	public LoginDto get() {
		return this.dtoFactory.login().as();
	}

}
