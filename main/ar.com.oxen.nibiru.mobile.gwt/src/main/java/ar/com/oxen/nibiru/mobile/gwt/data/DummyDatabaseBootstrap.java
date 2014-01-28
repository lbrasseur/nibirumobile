package ar.com.oxen.nibiru.mobile.gwt.data;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.gwt.app.DatabaseBootstrap;

public class DummyDatabaseBootstrap implements DatabaseBootstrap {
	@Override
	public void createDatabase(Callback<Void> callback) {
		checkNotNull(callback);
		callback.onSuccess(null);
	}
}
