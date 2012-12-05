package ar.com.oxen.nibiru.mobile.core.ioc;

import ar.com.oxen.nibiru.mobile.core.api.business.security.AuthenticationManager;
import ar.com.oxen.nibiru.mobile.core.api.business.security.HashManager;
import ar.com.oxen.nibiru.mobile.core.api.business.security.Profile;
import ar.com.oxen.nibiru.mobile.core.impl.business.security.AuthenticationManagerImpl;
import ar.com.oxen.nibiru.mobile.core.impl.business.security.DummyHashManager;
import ar.com.oxen.nibiru.mobile.core.impl.business.security.ProfileImpl;

import com.google.inject.AbstractModule;

public class DefaultSecurityModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(AuthenticationManager.class).to(AuthenticationManagerImpl.class);
		bind(Profile.class).to(ProfileImpl.class);
		bind(HashManager.class).to(DummyHashManager.class);
	}
}
