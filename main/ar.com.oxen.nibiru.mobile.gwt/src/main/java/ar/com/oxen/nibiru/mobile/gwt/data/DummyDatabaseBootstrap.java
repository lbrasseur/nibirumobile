package ar.com.oxen.nibiru.mobile.gwt.data;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.gwt.app.DatabaseBootstrap;

public class DummyDatabaseBootstrap implements DatabaseBootstrap {
	@Override
	public void createDatabase(Callback<Void> callback) {
		callback.onSuccess(null);
	}
}
