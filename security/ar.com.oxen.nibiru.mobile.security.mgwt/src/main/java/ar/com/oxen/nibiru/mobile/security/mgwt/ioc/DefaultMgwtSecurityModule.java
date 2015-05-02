package ar.com.oxen.nibiru.mobile.security.mgwt.ioc;

import ar.com.oxen.nibiru.mobile.security.core.impl.ui.LoginPresenter;
import ar.com.oxen.nibiru.mobile.security.mgwt.ui.LoginDisplay;

import com.google.gwt.inject.client.AbstractGinModule;

public class DefaultMgwtSecurityModule extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(LoginPresenter.Display.class).to(LoginDisplay.class);
	}
}
