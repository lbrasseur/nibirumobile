package ar.com.oxen.nibiru.mobile.kendoui.ioc;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;
import ar.com.oxen.nibiru.mobile.gwt.ui.GwtAlertManager;
import ar.com.oxen.nibiru.mobile.kendoui.app.SimpleBootstrap;
import ar.com.oxen.nibiru.mobile.kendoui.ui.place.KendoUiPlaceManager;
import ar.com.oxen.nibiru.mobile.kendoui.ui.security.LoginDisplay;

import com.google.gwt.inject.client.AbstractGinModule;

public class DefaultKendoUiModule extends AbstractGinModule {
	@Override
	protected void configure() {
		/* APP bindings */
		bind(Bootstrap.class).to(SimpleBootstrap.class);

		/* UI bindings */
		bind(PlaceManager.class).to(KendoUiPlaceManager.class);
		bind(AlertManager.class).to(GwtAlertManager.class);

		/* Security bindings */
		bind(LoginPresenter.Display.class).to(LoginDisplay.class);
	}
}
