package ar.com.oxen.nibiru.mobile.android.ioc;

import ar.com.oxen.nibiru.mobile.android.geolocation.AndroidGeolocationManager;
import ar.com.oxen.nibiru.mobile.core.api.geolocation.GeolocationManager;

import com.google.inject.AbstractModule;

public class DefaultAndroidHardwareModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(GeolocationManager.class).to(AndroidGeolocationManager.class);
	}
}
