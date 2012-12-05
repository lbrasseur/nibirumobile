package ar.com.oxen.nibiru.mobile.android.ui.place;

import javax.inject.Inject;

import android.app.Activity;
import android.content.Intent;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

public class IntentPlaceManager implements PlaceManager {
	private Activity context;

	@Inject
	public IntentPlaceManager(Activity context) {
		super();
		this.context = context;
	}

	@Override
	public Place createPlace(String id) {
		return new IntentPlace(id, new Intent(String.format("%s.place.%s",
				this.context.getPackageName(), id)), context);
	}

	@Override
	public Place createPlace(Enum<?> id) {
		return this.createPlace(id.toString());
	}

	@Override
	public void back() {
		this.context.finish();
	}
}
