package ar.com.oxen.nibiru.mobile.mgwt.ioc;

import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.Looper;
import ar.com.oxen.nibiru.mobile.gwt.app.AppWidgetBootstrap;
import ar.com.oxen.nibiru.mobile.gwt.ui.SchedulerLooper;
import ar.com.oxen.nibiru.mobile.mgwt.app.MgwtAppWidgetBootstrap;
import ar.com.oxen.nibiru.mobile.mgwt.ui.MgwtAlertManager;
import ar.com.oxen.nibiru.mobile.mgwt.ui.place.DefaultAnimationMapper;

import com.google.gwt.inject.client.AbstractGinModule;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

public class DefaultMgwtUiModule extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(AlertManager.class).to(MgwtAlertManager.class);
		bind(Looper.class).to(SchedulerLooper.class);
		bind(AnimationMapper.class).to(DefaultAnimationMapper.class);
		bind(AppWidgetBootstrap.class).to(MgwtAppWidgetBootstrap.class);
	}
}
