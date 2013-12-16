package ar.com.oxen.nibiru.mobile.ios.ioc;

import org.robovm.cocoatouch.uikit.UIScreen;
import org.robovm.cocoatouch.uikit.UIWindow;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.event.EventBus;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;
import ar.com.oxen.nibiru.mobile.core.api.preferences.Preferences;
import ar.com.oxen.nibiru.mobile.core.api.serializer.Serializer;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;
import ar.com.oxen.nibiru.mobile.ios.app.IosBootstrap;
import ar.com.oxen.nibiru.mobile.ios.event.DummyEventBus;
import ar.com.oxen.nibiru.mobile.ios.http.DummyHttpManager;
import ar.com.oxen.nibiru.mobile.ios.preferences.DummyPreferences;
import ar.com.oxen.nibiru.mobile.ios.serializer.DummySerializer;
import ar.com.oxen.nibiru.mobile.ios.ui.UIAlertViewAlertManager;
import ar.com.oxen.nibiru.mobile.ios.ui.place.UINavigationControllerPlaceManager;

import com.google.inject.AbstractModule;

public class DefaultIosModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Bootstrap.class).to(IosBootstrap.class);
		bind(AlertManager.class).to(UIAlertViewAlertManager.class);
		bind(PlaceManager.class).to(UINavigationControllerPlaceManager.class);
		bind(EventBus.class).to(DummyEventBus.class);
		bind(HttpManager.class).to(DummyHttpManager.class);
		bind(Serializer.class).to(DummySerializer.class);
		bind(Preferences.class).to(DummyPreferences.class);

		bind(UIWindow.class).toInstance(
				new UIWindow(UIScreen.getMainScreen().getBounds()));
	}
}
