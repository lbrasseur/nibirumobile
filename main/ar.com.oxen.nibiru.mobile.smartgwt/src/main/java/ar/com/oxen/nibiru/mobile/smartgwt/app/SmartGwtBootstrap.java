package ar.com.oxen.nibiru.mobile.smartgwt.app;

import javax.inject.Inject;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.mobile.client.widgets.layout.NavStack;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.gwt.app.DatabaseBootstrap;

public class SmartGwtBootstrap implements Bootstrap {
	private EntryPoint entryPoint;
	private NavStack<?> navStack;
	private DatabaseBootstrap databaseBootstrap;

	@Inject
	public SmartGwtBootstrap(EntryPoint entryPoint, NavStack<?> navStack,
			DatabaseBootstrap databaseBootstrap) {
		super();
		this.entryPoint = entryPoint;
		this.navStack = navStack;
		this.databaseBootstrap = databaseBootstrap;
	}

	@Override
	public void onBootstrap() {
		RootPanel.get().add(navStack);
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
