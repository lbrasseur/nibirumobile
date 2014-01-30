package ar.com.oxen.nibiru.mobile.kendoui.app;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.gwt.app.DatabaseBootstrap;

import com.google.gwt.user.client.Window;

public class SimpleBootstrap implements Bootstrap {
	private final EntryPoint entryPoint;
	private final DatabaseBootstrap databaseBootstrap;
	private final ViewCreator viewCreator;

	@Inject
	public SimpleBootstrap(EntryPoint entryPoint,
			DatabaseBootstrap databaseBootstrap, ViewCreator viewCreator) {
		this.entryPoint = checkNotNull(entryPoint);
		this.databaseBootstrap = checkNotNull(databaseBootstrap);
		this.viewCreator = checkNotNull(viewCreator);
	}

	@Override
	public void onBootstrap() {
		viewCreator.createViews();
		databaseBootstrap.createDatabase(new Callback<Void>() {
			@Override
			public void onSuccess(Void result) {
				entryPoint.onApplicationStart();
			}

			@Override
			public void onFailure(Exception reason) {
				Window.alert("Database error: " + reason.getMessage());
			}
		});
	}
}
