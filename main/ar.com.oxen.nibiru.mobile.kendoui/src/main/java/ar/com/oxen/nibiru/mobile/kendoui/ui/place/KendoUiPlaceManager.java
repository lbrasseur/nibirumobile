package ar.com.oxen.nibiru.mobile.kendoui.ui.place;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.PresenterMapper;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

public class KendoUiPlaceManager implements PlaceManager {
	private final PresenterMapper presenterMapper;

	@Inject
	public KendoUiPlaceManager(PresenterMapper presenterMapper) {
		this.presenterMapper = checkNotNull(presenterMapper);
	}

	@Override
	public Place createPlace(String id) {
		return new KendoUiPlace(id, presenterMapper);
	}

	@Override
	public Place createPlace(Enum<?> id) {
		return createPlace(id.toString());
	}

	@Override
	public native void back() /*-{
		$wnd.kendoMobileApplication.navigate("#:back");
	}-*/;
}
