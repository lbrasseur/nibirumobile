package ar.com.oxen.nibiru.mobile.sample.kendoui.client;

import javax.inject.Provider;
import javax.inject.Singleton;

import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.config.AppName;
import ar.com.oxen.nibiru.mobile.core.api.config.AppVersion;
import ar.com.oxen.nibiru.mobile.core.api.config.BaseUrl;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.impl.service.security.Authentication;
import ar.com.oxen.nibiru.mobile.gwt.app.DatabaseBootstrap;
import ar.com.oxen.nibiru.mobile.gwt.data.GwtMobileDatabaseBootstrap;
import ar.com.oxen.nibiru.mobile.gwt.service.security.RestAutoBeanAuthenticationServiceProvider;
import ar.com.oxen.nibiru.mobile.kendoui.app.ViewCreator;
import ar.com.oxen.nibiru.mobile.kendoui.ui.security.LoginDisplay;
import ar.com.oxen.nibiru.mobile.sample.app.app.SampleEntryPoint;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenter;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenterMapper;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.AbstractGinModule;

public class Module extends AbstractGinModule {

	@Override
	protected void configure() {
		/* App bindings */
		bind(String.class).annotatedWith(AppName.class).toProvider(
				AppNameProvider.class);
		bind(Integer.class).annotatedWith(AppVersion.class).toProvider(
				AppVersionProvider.class);
		bind(String.class).annotatedWith(BaseUrl.class).toProvider(
				BaseUrlProvider.class);

		bind(EntryPoint.class).to(SampleEntryPoint.class);

		/* UI bindings */
		bind(PresenterMapper.class).to(SamplePresenterMapper.class);
		bind(ViewCreator.class).to(SampleViewCreator.class);
		bind(LoginDisplay.class).in(Singleton.class);
		bind(SamplePresenter.Display.class).to(SampleDisplay.class).in(Singleton.class);
		bind(SampleMessages.class).to(GwtSampleMessages.class);

		/* Database bindings */
		bind(DatabaseBootstrap.class).to(GwtMobileDatabaseBootstrap.class);

		/* Service bindings */
		bind(RemoteService.class).annotatedWith(Authentication.class)
				.toProvider(RestAutoBeanAuthenticationServiceProvider.class);

	}

	public static class AppNameProvider implements Provider<String> {
		@Override
		public String get() {
			return "NibiruSample";
		}
	}

	public static class AppVersionProvider implements Provider<Integer> {
		@Override
		public Integer get() {
			return 1;
		}
	}

	public static class BaseUrlProvider implements Provider<String> {
		@Override
		public String get() {
			return GWT.getHostPageBaseURL()
					+ "../ar.com.oxen.nibiru.mobile.sample.server/";
		}
	}
}
