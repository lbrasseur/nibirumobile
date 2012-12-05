package ar.com.oxen.nibiru.mobile.gwt.ui.place;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.History;

public class GwtPlaceManager implements PlaceManager {
	private PlaceController placeController;
	private static int creationCount;

	@Inject
	public GwtPlaceManager(PlaceController placeController) {
		super();
		this.placeController = placeController;
	}

	@Override
	public Place createPlace(String id) {
		return new SimplePlace(id, creationCount++, this.placeController);
	}

	@Override
	public Place createPlace(Enum<?> id) {
		return this.createPlace(id.toString());
	}

	@Override
	public void back() {
		History.back();
	}

}
