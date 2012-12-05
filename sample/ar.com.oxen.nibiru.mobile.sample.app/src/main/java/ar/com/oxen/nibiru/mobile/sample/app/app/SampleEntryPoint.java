package ar.com.oxen.nibiru.mobile.sample.app.app;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.DefaultPlaces;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

public class SampleEntryPoint implements EntryPoint {
	private PlaceManager placeManager;

	@Inject
	public SampleEntryPoint(PlaceManager placeManager) {
		super();
		this.placeManager = placeManager;
	}

	@Override
	public void onApplicationStart() {
		this.placeManager.createPlace(DefaultPlaces.LOGIN).go();
	}

}
