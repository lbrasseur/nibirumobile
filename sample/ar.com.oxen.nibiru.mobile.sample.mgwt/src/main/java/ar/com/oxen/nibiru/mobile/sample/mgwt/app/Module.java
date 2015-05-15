package ar.com.oxen.nibiru.mobile.sample.mgwt.app;

import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.config.AppName;
import ar.com.oxen.nibiru.mobile.core.api.config.AppVersion;
import ar.com.oxen.nibiru.mobile.core.api.config.BaseUrl;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.gwt.app.DatabaseBootstrap;
import ar.com.oxen.nibiru.mobile.gwt.data.GwtMobileDatabaseBootstrap;
import ar.com.oxen.nibiru.mobile.sample.app.api.business.CustomerManager;
import ar.com.oxen.nibiru.mobile.sample.app.api.data.CustomerDao;
import ar.com.oxen.nibiru.mobile.sample.app.impl.SampleEntryPoint;
import ar.com.oxen.nibiru.mobile.sample.app.impl.business.CustomerManagerImpl;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerFormPresenter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.CustomerManagementPresenter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.MainMenuPresenter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SamplePresenter;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SamplePresenterMapper;
import ar.com.oxen.nibiru.mobile.sample.app.impl.ui.SecondPresenter;
import ar.com.oxen.nibiru.mobile.sample.mgwt.data.GwtMobileCustomerDao;
import ar.com.oxen.nibiru.mobile.sample.mgwt.ui.CustomerFormDisplay;
import ar.com.oxen.nibiru.mobile.sample.mgwt.ui.CustomerManagementDisplay;
import ar.com.oxen.nibiru.mobile.sample.mgwt.ui.GwtSampleMessages;
import ar.com.oxen.nibiru.mobile.sample.mgwt.ui.MainMenuDisplay;
import ar.com.oxen.nibiru.mobile.sample.mgwt.ui.SampleDisplay;
import ar.com.oxen.nibiru.mobile.sample.mgwt.ui.SecondDisplay;

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
		bind(MainMenuPresenter.Display.class).to(MainMenuDisplay.class);
		bind(CustomerManagementPresenter.Display.class).to(
				CustomerManagementDisplay.class);
		bind(CustomerFormPresenter.Display.class).to(CustomerFormDisplay.class);
		bind(SamplePresenter.Display.class).to(SampleDisplay.class);
		bind(SecondPresenter.Display.class).to(SecondDisplay.class);
		bind(SampleMessages.class).to(GwtSampleMessages.class);

		/* Business bindings */
		bind(CustomerManager.class).to(CustomerManagerImpl.class);

		/* Database bindings */
		bind(DatabaseBootstrap.class).to(GwtMobileDatabaseBootstrap.class);
		bind(CustomerDao.class).to(GwtMobileCustomerDao.class);
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
