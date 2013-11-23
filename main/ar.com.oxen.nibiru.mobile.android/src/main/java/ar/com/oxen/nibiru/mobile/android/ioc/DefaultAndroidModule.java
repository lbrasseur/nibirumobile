package ar.com.oxen.nibiru.mobile.android.ioc;

import ar.com.oxen.nibiru.mobile.android.app.AndroidBootstrap;
import ar.com.oxen.nibiru.mobile.android.event.BroadcasEventBus;
import ar.com.oxen.nibiru.mobile.android.http.HttpClientHttpManager;
import ar.com.oxen.nibiru.mobile.android.preferences.SharedPreferencesImpl;
import ar.com.oxen.nibiru.mobile.android.serializer.JacksonSerializer;
import ar.com.oxen.nibiru.mobile.android.ui.ToastAlertManager;
import ar.com.oxen.nibiru.mobile.android.ui.place.IntentPlaceManager;
import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.event.EventBus;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;
import ar.com.oxen.nibiru.mobile.core.api.preferences.Preferences;
import ar.com.oxen.nibiru.mobile.core.api.serializer.Serializer;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

import com.google.inject.AbstractModule;

public class DefaultAndroidModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Bootstrap.class).to(AndroidBootstrap.class);
		bind(AlertManager.class).to(ToastAlertManager.class);
		bind(PlaceManager.class).to(IntentPlaceManager.class);
		bind(EventBus.class).to(BroadcasEventBus.class);
		bind(HttpManager.class).to(HttpClientHttpManager.class);
		bind(Serializer.class).to(JacksonSerializer.class);
		bind(Preferences.class).to(SharedPreferencesImpl.class);
	}
}
