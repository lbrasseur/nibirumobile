package ar.com.oxen.nibiru.mobile.gwt.ioc;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.app.Bootstrap;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;
import ar.com.oxen.nibiru.mobile.gwt.app.GwtPlacesBootstrap;
import ar.com.oxen.nibiru.mobile.gwt.ui.place.DefaultActivityMapper;
import ar.com.oxen.nibiru.mobile.gwt.ui.place.DefaultPlaceHistoryMapper;
import ar.com.oxen.nibiru.mobile.gwt.ui.place.GwtPlaceManager;

import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryMapper;

public class DefaultGwtPlacesModule extends AbstractGinModule {

	@Override
	protected void configure() {
		bind(Bootstrap.class).to(GwtPlacesBootstrap.class);
		bind(PlaceManager.class).to(GwtPlaceManager.class);

		bind(PlaceController.class).toProvider(PlaceControllerProvider.class);
		bind(ActivityMapper.class).to(DefaultActivityMapper.class);
		bind(PlaceHistoryMapper.class).to(DefaultPlaceHistoryMapper.class);
	}

	public static class PlaceControllerProvider implements
			Provider<PlaceController> {
		private final com.google.web.bindery.event.shared.EventBus eventBus;

		@Inject
		public PlaceControllerProvider(
				com.google.web.bindery.event.shared.EventBus eventBus) {
			this.eventBus = checkNotNull(eventBus);
		}

		@Override
		public PlaceController get() {
			return new PlaceController(eventBus);
		}
	}
}
