package ar.com.oxen.nibiru.mobile.sample.mgwt.firefox.client;

import ar.com.oxen.nibiru.mobile.core.api.business.security.AuthenticationManager;
import ar.com.oxen.nibiru.mobile.core.api.business.security.Profile;
import ar.com.oxen.nibiru.mobile.core.api.ui.security.SecurityMessages;
import ar.com.oxen.nibiru.mobile.core.impl.business.security.ProfileImpl;
import ar.com.oxen.nibiru.mobile.gwt.ui.security.GwtSecurityMessages;

import com.google.gwt.inject.client.AbstractGinModule;

public class DummySecurityModule  extends AbstractGinModule {

	@Override
	protected void configure() {
		/* Business bindings */
		bind(AuthenticationManager.class).to(DummyAuthenticationManager.class);
		bind(Profile.class).to(ProfileImpl.class);

		/* UI bindings */
		bind(SecurityMessages.class).to(GwtSecurityMessages.class);
	}
}
