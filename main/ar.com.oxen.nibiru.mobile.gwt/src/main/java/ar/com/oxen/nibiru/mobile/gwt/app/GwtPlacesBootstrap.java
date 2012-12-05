package ar.com.oxen.nibiru.mobile.gwt.app;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.gwt.ui.place.SimplePlace;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.web.bindery.event.shared.EventBus;

public class GwtPlacesBootstrap implements Bootstrap {
	private EntryPoint entryPoint;
	private EventBus eventBus;
	private PlaceController placeController;
	private PlaceHistoryMapper placeHistoryMapper;
	private AppWidgetBootstrap appWidgetBootstrap;
	private DatabaseBootstrap databaseBootstrap;

	@Inject
	public GwtPlacesBootstrap(EntryPoint entryPoint, EventBus eventBus,
			PlaceController placeController,
			PlaceHistoryMapper placeHistoryMapper,
			AppWidgetBootstrap appWidgetBootstrap,
			DatabaseBootstrap databaseBootstrap) {
		super();
		this.entryPoint = entryPoint;
		this.eventBus = eventBus;
		this.placeController = placeController;
		this.placeHistoryMapper = placeHistoryMapper;
		this.appWidgetBootstrap = appWidgetBootstrap;
		this.databaseBootstrap = databaseBootstrap;
	}

	@Override
	public void onBootstrap() {
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(
				this.placeHistoryMapper);

		historyHandler.register(this.placeController, this.eventBus,
				new SimplePlace(null, 0, null));

		RootPanel.get().add(this.appWidgetBootstrap.createAppWidget());

		historyHandler.handleCurrentHistory();

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
