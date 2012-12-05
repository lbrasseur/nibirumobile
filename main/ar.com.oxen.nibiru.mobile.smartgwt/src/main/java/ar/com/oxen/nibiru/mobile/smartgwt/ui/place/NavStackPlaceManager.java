package ar.com.oxen.nibiru.mobile.smartgwt.ui.place;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

import com.smartgwt.mobile.client.widgets.layout.NavStack;

public class NavStackPlaceManager implements PlaceManager {
	private NavStack<?> navStack;
	private PresenterMapper presenterMapper;

	@Inject
	public NavStackPlaceManager(NavStack<?> navStack,
			PresenterMapper presenterMapper) {
		super();
		this.navStack = navStack;
		this.presenterMapper = presenterMapper;
	}

	@Override
	public Place createPlace(String id) {
		return new NavStackPlace(id, this.navStack, this.presenterMapper);
	}

	@Override
	public Place createPlace(Enum<?> id) {
		return this.createPlace(id.toString());
	}

	@Override
	public void back() {
		this.navStack.pop();
	}
}
