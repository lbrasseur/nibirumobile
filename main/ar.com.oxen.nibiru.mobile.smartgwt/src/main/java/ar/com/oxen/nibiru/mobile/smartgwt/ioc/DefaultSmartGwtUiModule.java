package ar.com.oxen.nibiru.mobile.smartgwt.ioc;

import javax.inject.Singleton;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;
import ar.com.oxen.nibiru.mobile.gwt.ui.GwtAlertManager;
import ar.com.oxen.nibiru.mobile.smartgwt.app.SmartGwtBootstrap;
import ar.com.oxen.nibiru.mobile.smartgwt.ui.place.NavStackPlaceManager;
import ar.com.oxen.nibiru.mobile.smartgwt.ui.security.LoginDisplay;

import com.google.gwt.inject.client.AbstractGinModule;
import com.google.inject.TypeLiteral;
import com.smartgwt.mobile.client.widgets.layout.NavStack;

public class DefaultSmartGwtUiModule extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(Bootstrap.class).to(SmartGwtBootstrap.class);
		bind(AlertManager.class).to(GwtAlertManager.class);
		bind(PlaceManager.class).to(NavStackPlaceManager.class);
		bind(new TypeLiteral<NavStack<?>>() {
		}).to(NavStack.class).in(Singleton.class);

		/* Security bindings */
		bind(LoginPresenter.Display.class).to(LoginDisplay.class);
	}
}
