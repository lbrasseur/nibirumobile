package ar.com.oxen.nibiru.mobile.gwt.service.security;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.service.security.LoginDto;

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
