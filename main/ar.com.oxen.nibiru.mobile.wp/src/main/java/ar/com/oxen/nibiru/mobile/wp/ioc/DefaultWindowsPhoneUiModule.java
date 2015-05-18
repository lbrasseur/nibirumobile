package ar.com.oxen.nibiru.mobile.wp.ioc;

import javax.inject.Singleton;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.Looper;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;
import ar.com.oxen.nibiru.mobile.gwt.ui.SchedulerLooper;
import ar.com.oxen.nibiru.mobile.wp.app.WindowsPhoneBootstrap;
import ar.com.oxen.nibiru.mobile.wp.ui.WindowsPhoneAlertManager;
import ar.com.oxen.nibiru.mobile.wp.ui.place.WindowsPhonePlaceManager;

import com.google.gwt.inject.client.AbstractGinModule;

public class DefaultWindowsPhoneUiModule extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(AlertManager.class).to(WindowsPhoneAlertManager.class);
		bind(Looper.class).to(SchedulerLooper.class);

		bind(Bootstrap.class).to(WindowsPhoneBootstrap.class);
		bind(PlaceManager.class).to(WindowsPhonePlaceManager.class).in(
				Singleton.class);
	}
}
