package ar.com.oxen.nibiru.mobile.sample.android.app;

import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.config.AppName;
import ar.com.oxen.nibiru.mobile.core.api.config.AppVersion;
import ar.com.oxen.nibiru.mobile.core.api.config.BaseUrl;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.java.ui.i18n.MessageProvider;
import ar.com.oxen.nibiru.mobile.sample.android.data.DatabaseHelper;
import ar.com.oxen.nibiru.mobile.sample.android.data.OrmLiteCustomerDao;
import ar.com.oxen.nibiru.mobile.sample.android.ui.CustomerFormDisplay;
import ar.com.oxen.nibiru.mobile.sample.android.ui.CustomerManagementDisplay;
import ar.com.oxen.nibiru.mobile.sample.android.ui.MainMenuDisplay;
import ar.com.oxen.nibiru.mobile.sample.android.ui.SampleDisplay;
import ar.com.oxen.nibiru.mobile.sample.android.ui.SecondDisplay;
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

import com.google.inject.AbstractModule;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;

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
						"http://192.168.1.119:8080/ar.com.oxen.nibiru.mobile.sample.server/");

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
		bind(OrmLiteSqliteOpenHelper.class).to(DatabaseHelper.class);
		bind(CustomerDao.class).to(OrmLiteCustomerDao.class);
	}
}
