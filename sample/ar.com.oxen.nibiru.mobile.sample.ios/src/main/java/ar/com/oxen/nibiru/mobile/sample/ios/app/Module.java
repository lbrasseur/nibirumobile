package ar.com.oxen.nibiru.mobile.sample.ios.app;

import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.config.AppName;
import ar.com.oxen.nibiru.mobile.core.api.config.AppVersion;
import ar.com.oxen.nibiru.mobile.core.api.config.BaseUrl;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.java.ui.i18n.MessageProvider;
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
import ar.com.oxen.nibiru.mobile.sample.ios.data.CoreDataCustomerDao;
import ar.com.oxen.nibiru.mobile.sample.ios.ui.CustomerFormDisplay;
import ar.com.oxen.nibiru.mobile.sample.ios.ui.CustomerManagementDisplay;
import ar.com.oxen.nibiru.mobile.sample.ios.ui.MainMenuDisplay;
import ar.com.oxen.nibiru.mobile.sample.ios.ui.SampleDisplay;
import ar.com.oxen.nibiru.mobile.sample.ios.ui.SecondDisplay;

import com.google.inject.AbstractModule;

public class Module extends AbstractModule {
	@Override
	protected void configure() {
		/* App bindings */
		bind(String.class).annotatedWith(AppName.class).toInstance(
				"NibiruSample");
		bind(Integer.class).annotatedWith(AppVersion.class).toInstance(1);
		bind(String.class)
				.annotatedWith(BaseUrl.class)
				.toInstance(
						"http://localhost:8080/ar.com.oxen.nibiru.mobile.sample.server/");

		bind(EntryPoint.class).to(SampleEntryPoint.class);

		/* UI bindings */
		bind(PresenterMapper.class).to(SamplePresenterMapper.class);
		bind(MainMenuPresenter.Display.class).to(MainMenuDisplay.class);
		bind(CustomerManagementPresenter.Display.class).to(CustomerManagementDisplay.class);
		bind(CustomerFormPresenter.Display.class).to(CustomerFormDisplay.class);
		bind(SamplePresenter.Display.class).to(SampleDisplay.class);
		bind(SecondPresenter.Display.class).to(SecondDisplay.class);
		bind(SampleMessages.class).toProvider(
				new MessageProvider<SampleMessages>(SampleMessages.class));

		/* Business bindings */
		bind(CustomerManager.class).to(CustomerManagerImpl.class);

		/* Data bindings */
		bind(CustomerDao.class).to(CoreDataCustomerDao.class);
	}
}
