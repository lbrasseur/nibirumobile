package ar.com.oxen.nibiru.mobile.sample.android;

import org.codehaus.jackson.map.ObjectMapper;

import ar.com.oxen.nibiru.mobile.android.ioc.MessageProvider;
import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.config.AppName;
import ar.com.oxen.nibiru.mobile.core.api.config.AppVersion;
import ar.com.oxen.nibiru.mobile.core.api.config.BaseUrl;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.impl.service.security.Authentication;
import ar.com.oxen.nibiru.mobile.java.service.security.JsonRestAuthenticationServiceProvider;
import ar.com.oxen.nibiru.mobile.sample.app.app.SampleEntryPoint;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SampleMessages;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenter;
import ar.com.oxen.nibiru.mobile.sample.app.ui.SamplePresenterMapper;

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
						"http://servidor.oxen.com.ar/ar.com.oxen.nibiru.mobile.sample.server/");

		bind(EntryPoint.class).to(SampleEntryPoint.class);

		/* UI bindings */
		bind(PresenterMapper.class).to(SamplePresenterMapper.class);
		bind(SamplePresenter.Display.class).to(SampleDisplay.class);
		bind(SampleMessages.class).toProvider(
				new MessageProvider<SampleMessages>(SampleMessages.class));

		/* Data bindings */
		bind(OrmLiteSqliteOpenHelper.class).to(DatabaseHelper.class);

		/* Service bindings */
		bind(ObjectMapper.class).toProvider(ObjectMapperProvider.class);
		bind(RemoteService.class).annotatedWith(Authentication.class)
				.toProvider(JsonRestAuthenticationServiceProvider.class);
	}
}
