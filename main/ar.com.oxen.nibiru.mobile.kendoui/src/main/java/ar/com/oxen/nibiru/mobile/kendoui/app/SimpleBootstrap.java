package ar.com.oxen.nibiru.mobile.kendoui.app;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.gwt.app.DatabaseBootstrap;

import com.google.gwt.user.client.Window;

public class SimpleBootstrap implements Bootstrap {
	private EntryPoint entryPoint;
	private DatabaseBootstrap databaseBootstrap;
	private ViewCreator viewCreator;

	@Inject
	public SimpleBootstrap(EntryPoint entryPoint,
			DatabaseBootstrap databaseBootstrap, ViewCreator viewCreator) {
		super();
		this.entryPoint = entryPoint;
		this.databaseBootstrap = databaseBootstrap;
		this.viewCreator = viewCreator;
	}

	@Override
	public void onBootstrap() {
		this.viewCreator.createViews();
		this.databaseBootstrap.createDatabase(new Callback<Void>() {
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
