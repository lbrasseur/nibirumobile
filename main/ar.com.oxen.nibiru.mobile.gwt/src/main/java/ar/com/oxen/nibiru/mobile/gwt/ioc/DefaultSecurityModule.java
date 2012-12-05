package ar.com.oxen.nibiru.mobile.gwt.ioc;

import ar.com.oxen.nibiru.mobile.core.api.business.security.AuthenticationManager;
import ar.com.oxen.nibiru.mobile.core.api.business.security.HashManager;
import ar.com.oxen.nibiru.mobile.core.api.business.security.Profile;
import ar.com.oxen.nibiru.mobile.core.api.data.security.UserDao;
import ar.com.oxen.nibiru.mobile.core.api.service.security.AuthenticationService;
import ar.com.oxen.nibiru.mobile.core.api.service.security.LoginDto;
import ar.com.oxen.nibiru.mobile.core.api.ui.security.SecurityMessages;
import ar.com.oxen.nibiru.mobile.core.impl.business.security.AuthenticationManagerImpl;
import ar.com.oxen.nibiru.mobile.core.impl.business.security.DummyHashManager;
import ar.com.oxen.nibiru.mobile.core.impl.business.security.ProfileImpl;
import ar.com.oxen.nibiru.mobile.core.impl.service.security.AuthenticationServiceImpl;
import ar.com.oxen.nibiru.mobile.gwt.data.security.GwtMobileUserDao;
import ar.com.oxen.nibiru.mobile.gwt.service.security.AutoBeanLoginDtoProvider;
import ar.com.oxen.nibiru.mobile.gwt.ui.security.GwtSecurityMessages;

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
