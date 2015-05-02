package ar.com.oxen.nibiru.mobile.security.gwt.service;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.security.core.api.service.LoginDto;

public class AutoBeanLoginDtoProvider implements Provider<LoginDto> {
	private final AutoBeanDtoFactory dtoFactory;

	@Inject
	public AutoBeanLoginDtoProvider(AutoBeanDtoFactory dtoFactory) {
		this.dtoFactory = checkNotNull(dtoFactory);
	}

	@Override
	public LoginDto get() {
		return dtoFactory.login().as();
	}
}
