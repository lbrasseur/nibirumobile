package ar.com.oxen.nibiru.mobile.sample.app.impl;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.app.EntryPoint;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.DefaultPlaces;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

public class SampleEntryPoint implements EntryPoint {
	private final PlaceManager placeManager;

	@Inject
	public SampleEntryPoint(PlaceManager placeManager) {
		this.placeManager = checkNotNull(placeManager);
	}

	@Override
	public void onApplicationStart() {
		placeManager.createPlace(DefaultPlaces.HOME).go();
	}
}
