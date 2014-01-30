package ar.com.oxen.nibiru.mobile.smartgwt.app;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.mobile.client.widgets.layout.NavStack;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.gwt.app.DatabaseBootstrap;

public class SmartGwtBootstrap implements Bootstrap {
	private final EntryPoint entryPoint;
	private final NavStack<?> navStack;
	private final DatabaseBootstrap databaseBootstrap;

	@Inject
	public SmartGwtBootstrap(EntryPoint entryPoint, NavStack<?> navStack,
			DatabaseBootstrap databaseBootstrap) {
		this.entryPoint = checkNotNull(entryPoint);
		this.navStack = checkNotNull(navStack);
		this.databaseBootstrap = checkNotNull(databaseBootstrap);
	}

	@Override
	public void onBootstrap() {
		RootPanel.get().add(navStack);
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
