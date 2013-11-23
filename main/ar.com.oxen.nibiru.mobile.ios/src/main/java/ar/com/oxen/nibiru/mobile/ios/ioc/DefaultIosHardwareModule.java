package ar.com.oxen.nibiru.mobile.ios.ioc;

import ar.com.oxen.nibiru.mobile.core.api.geolocation.GeolocationManager;
import ar.com.oxen.nibiru.mobile.ios.geolocation.DummyGeolocationManager;

import com.google.inject.AbstractModule;

public class DefaultIosHardwareModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(GeolocationManager.class).to(DummyGeolocationManager.class);
	}
}
