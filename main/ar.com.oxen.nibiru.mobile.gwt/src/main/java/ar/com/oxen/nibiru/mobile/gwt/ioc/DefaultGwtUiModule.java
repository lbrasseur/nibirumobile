package ar.com.oxen.nibiru.mobile.gwt.ioc;

import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.Looper;
import ar.com.oxen.nibiru.mobile.gwt.app.AppWidgetBootstrap;
import ar.com.oxen.nibiru.mobile.gwt.app.GwtAppWidgetBootstrap;
import ar.com.oxen.nibiru.mobile.gwt.ui.GwtAlertManager;
import ar.com.oxen.nibiru.mobile.gwt.ui.SchedulerLooper;

import com.google.gwt.inject.client.AbstractGinModule;

public class DefaultGwtUiModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(AlertManager.class).to(GwtAlertManager.class);
		bind(Looper.class).to(SchedulerLooper.class);
		bind(AppWidgetBootstrap.class).to(GwtAppWidgetBootstrap.class);
	}
}
