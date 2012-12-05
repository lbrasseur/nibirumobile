package ar.com.oxen.nibiru.mobile.gwt.data;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.config.AppName;
import ar.com.oxen.nibiru.mobile.gwt.app.DatabaseBootstrap;

import com.gwtmobile.persistence.client.Callback;
import com.gwtmobile.persistence.client.Persistence;

public class GwtMobileDatabaseBootstrap implements DatabaseBootstrap {
	private String appName;

	@Inject
	public GwtMobileDatabaseBootstrap(@AppName String appName) {
		super();
		this.appName = appName;
	}

	@Override
	public void createDatabase(
			final ar.com.oxen.nibiru.mobile.core.api.async.Callback<Void> callback) {
		Persistence.connect(appName, appName + " database", 5 * 1024 * 1024);

		Persistence.schemaSync(new Callback() {
			public void onSuccess() {
				callback.onSuccess(null);
			}
		});
	}
}
