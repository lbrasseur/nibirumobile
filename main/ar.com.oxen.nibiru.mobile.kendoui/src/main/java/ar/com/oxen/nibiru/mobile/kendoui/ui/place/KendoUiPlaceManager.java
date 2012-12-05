package ar.com.oxen.nibiru.mobile.kendoui.ui.place;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

public class KendoUiPlaceManager implements PlaceManager {
	private PresenterMapper presenterMapper;

	@Inject
	public KendoUiPlaceManager(PresenterMapper presenterMapper) {
		super();
		this.presenterMapper = presenterMapper;
	}

	@Override
	public Place createPlace(String id) {
		return new KendoUiPlace(id, this.presenterMapper);
	}

	@Override
	public Place createPlace(Enum<?> id) {
		return this.createPlace(id.toString());
	}

	@Override
	public native void back() /*-{
		$wnd.kendoMobileApplication.navigate("#:back");
	}-*/;
}
