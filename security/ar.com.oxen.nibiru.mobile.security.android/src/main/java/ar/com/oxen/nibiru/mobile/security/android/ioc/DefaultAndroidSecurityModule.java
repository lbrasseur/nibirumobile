package ar.com.oxen.nibiru.mobile.security.android.ioc;

import ar.com.oxen.nibiru.mobile.java.ui.i18n.MessageProvider;
import ar.com.oxen.nibiru.mobile.security.android.data.OrmLiteUserDao;
import ar.com.oxen.nibiru.mobile.security.android.ui.LoginDisplay;
import ar.com.oxen.nibiru.mobile.security.core.api.data.UserDao;
import ar.com.oxen.nibiru.mobile.security.core.api.service.AuthenticationService;
import ar.com.oxen.nibiru.mobile.security.core.api.service.LoginDto;
import ar.com.oxen.nibiru.mobile.security.core.api.ui.SecurityMessages;
import ar.com.oxen.nibiru.mobile.security.core.impl.service.AuthenticationServiceImpl;
import ar.com.oxen.nibiru.mobile.security.core.impl.ui.LoginPresenter;
import ar.com.oxen.nibiru.mobile.security.java.service.LoginDtoImpl;

import com.google.inject.AbstractModule;

public class DefaultAndroidSecurityModule extends AbstractModule {
	@Override
	protected void configure() {
		/* Data bindings */
		bind(UserDao.class).to(OrmLiteUserDao.class);
		/* Service bindings */
		bind(LoginDto.class).to(LoginDtoImpl.class);
		bind(AuthenticationService.class).to(AuthenticationServiceImpl.class);
		/* UI bindings */
		bind(LoginPresenter.Display.class).to(LoginDisplay.class);
		bind(SecurityMessages.class).toProvider(
				new MessageProvider<SecurityMessages>(SecurityMessages.class));
	}
}
