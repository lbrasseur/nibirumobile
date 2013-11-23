package ar.com.oxen.nibiru.mobile.smartgwt.ui.place;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

import com.smartgwt.mobile.client.widgets.layout.NavStack;

public class NavStackPlaceManager implements PlaceManager {
	private final NavStack<?> navStack;
	private final PresenterMapper presenterMapper;

	@Inject
	public NavStackPlaceManager(NavStack<?> navStack,
			PresenterMapper presenterMapper) {
		this.navStack = checkNotNull(navStack);
		this.presenterMapper = checkNotNull(presenterMapper);
	}

	@Override
	public Place createPlace(String id) {
		checkNotNull(id);
		return new NavStackPlace(id, navStack, presenterMapper);
	}

	@Override
	public Place createPlace(Enum<?> id) {
		checkNotNull(id);
		return createPlace(id.toString());
	}

	@Override
	public void back() {
		navStack.pop();
	}
}
