package ar.com.oxen.nibiru.mobile.mgwt.ui.security;

import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;

import com.google.gwt.inject.client.AbstractGinModule;

public class DefaultMgwtSecurityModule extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(LoginPresenter.Display.class).to(LoginDisplay.class);
	}
}
