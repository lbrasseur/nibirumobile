package ar.com.oxen.nibiru.mobile.security.gwt.ioc;

import ar.com.oxen.nibiru.mobile.security.core.api.business.AuthenticationManager;
import ar.com.oxen.nibiru.mobile.security.core.api.business.HashManager;
import ar.com.oxen.nibiru.mobile.security.core.api.business.Profile;
import ar.com.oxen.nibiru.mobile.security.core.api.data.UserDao;
import ar.com.oxen.nibiru.mobile.security.core.api.service.AuthenticationService;
import ar.com.oxen.nibiru.mobile.security.core.api.service.LoginDto;
import ar.com.oxen.nibiru.mobile.security.core.api.ui.SecurityMessages;
import ar.com.oxen.nibiru.mobile.security.core.impl.business.AuthenticationManagerImpl;
import ar.com.oxen.nibiru.mobile.security.core.impl.business.DummyHashManager;
import ar.com.oxen.nibiru.mobile.security.core.impl.business.ProfileImpl;
import ar.com.oxen.nibiru.mobile.security.core.impl.service.AuthenticationServiceImpl;
import ar.com.oxen.nibiru.mobile.security.gwt.data.GwtMobileUserDao;
import ar.com.oxen.nibiru.mobile.security.gwt.service.AutoBeanLoginDtoProvider;
import ar.com.oxen.nibiru.mobile.security.gwt.ui.GwtSecurityMessages;

import com.google.gwt.inject.client.AbstractGinModule;

public class DefaultSecurityModule extends AbstractGinModule {

	@Override
	protected void configure() {
		/* Business bindings */
		bind(AuthenticationManager.class).to(AuthenticationManagerImpl.class);
		bind(Profile.class).to(ProfileImpl.class);
		bind(HashManager.class).to(DummyHashManager.class);

		/* Data bindings */
		bind(UserDao.class).to(GwtMobileUserDao.class);

		/* Service bindings */
		bind(LoginDto.class).toProvider(AutoBeanLoginDtoProvider.class);
		bind(AuthenticationService.class).to(AuthenticationServiceImpl.class);

		/* UI bindings */
		bind(SecurityMessages.class).to(GwtSecurityMessages.class);
	}
}
