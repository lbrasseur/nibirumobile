package ar.com.oxen.nibiru.mobile.gwt.ioc;

import ar.com.oxen.nibiru.mobile.core.api.geolocation.GeolocationManager;
import ar.com.oxen.nibiru.mobile.gwt.geolocation.PhoneGapGeolocationManager;

import com.google.gwt.inject.client.AbstractGinModule;

public class DefaultGwtHardwareModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(GeolocationManager.class).to(PhoneGapGeolocationManager.class);
	}
}
