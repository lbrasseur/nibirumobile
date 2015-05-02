package ar.com.oxen.nibiru.mobile.security.core.ioc;

import ar.com.oxen.nibiru.mobile.security.core.api.business.AuthenticationManager;
import ar.com.oxen.nibiru.mobile.security.core.api.business.HashManager;
import ar.com.oxen.nibiru.mobile.security.core.api.business.Profile;
import ar.com.oxen.nibiru.mobile.security.core.impl.business.AuthenticationManagerImpl;
import ar.com.oxen.nibiru.mobile.security.core.impl.business.DummyHashManager;
import ar.com.oxen.nibiru.mobile.security.core.impl.business.ProfileImpl;

import com.google.inject.AbstractModule;

public class DefaultSecurityModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(AuthenticationManager.class).to(AuthenticationManagerImpl.class);
		bind(Profile.class).to(ProfileImpl.class);
		bind(HashManager.class).to(DummyHashManager.class);
	}
}
