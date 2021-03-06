package ar.com.oxen.nibiru.mobile.android.ioc;

import ar.com.oxen.nibiru.mobile.android.app.AndroidBootstrap;
import ar.com.oxen.nibiru.mobile.android.event.BroadcasEventBus;
import ar.com.oxen.nibiru.mobile.android.preferences.SharedPreferencesImpl;
import ar.com.oxen.nibiru.mobile.android.ui.DialogAlertManager;
import ar.com.oxen.nibiru.mobile.android.ui.HandlerLooper;
import ar.com.oxen.nibiru.mobile.android.ui.place.IntentPlaceManager;
import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.event.EventBus;
import ar.com.oxen.nibiru.mobile.core.api.preferences.Preferences;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.Looper;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

import com.google.inject.AbstractModule;

public class DefaultAndroidModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Bootstrap.class).to(AndroidBootstrap.class);
		bind(AlertManager.class).to(DialogAlertManager.class);
		bind(Looper.class).to(HandlerLooper.class);
		bind(PlaceManager.class).to(IntentPlaceManager.class);
		bind(EventBus.class).to(BroadcasEventBus.class);
		bind(Preferences.class).to(SharedPreferencesImpl.class);
	}
}
