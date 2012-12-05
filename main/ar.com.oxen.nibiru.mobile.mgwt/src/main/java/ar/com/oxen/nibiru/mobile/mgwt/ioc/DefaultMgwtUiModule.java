package ar.com.oxen.nibiru.mobile.mgwt.ioc;

import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.impl.ui.security.LoginPresenter;
import ar.com.oxen.nibiru.mobile.gwt.app.AppWidgetBootstrap;
import ar.com.oxen.nibiru.mobile.mgwt.app.MgwtAppWidgetBootstrap;
import ar.com.oxen.nibiru.mobile.mgwt.ui.MgwtAlertManager;
import ar.com.oxen.nibiru.mobile.mgwt.ui.place.DefaultAnimationMapper;
import ar.com.oxen.nibiru.mobile.mgwt.ui.security.LoginDisplay;

import com.google.gwt.inject.client.AbstractGinModule;
import com.googlecode.mgwt.mvp.client.AnimationMapper;

public class DefaultMgwtUiModule extends AbstractGinModule {
	@Override
	protected void configure() {
		bind(AlertManager.class).to(MgwtAlertManager.class);
		bind(AnimationMapper.class).to(DefaultAnimationMapper.class);
		bind(AppWidgetBootstrap.class).to(MgwtAppWidgetBootstrap.class);

		/* Security bindings */
		bind(LoginPresenter.Display.class).to(LoginDisplay.class);
	}
}
