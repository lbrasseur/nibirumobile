package ar.com.oxen.nibiru.mobile.sample.mgwt.firefox.client;

import ar.com.oxen.nibiru.mobile.security.core.api.business.AuthenticationManager;
import ar.com.oxen.nibiru.mobile.security.core.api.business.Profile;
import ar.com.oxen.nibiru.mobile.security.core.api.ui.SecurityMessages;
import ar.com.oxen.nibiru.mobile.security.core.impl.business.ProfileImpl;
import ar.com.oxen.nibiru.mobile.security.gwt.ui.GwtSecurityMessages;

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
