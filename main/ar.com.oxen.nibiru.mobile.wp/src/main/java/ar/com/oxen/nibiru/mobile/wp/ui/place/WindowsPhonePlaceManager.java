package ar.com.oxen.nibiru.mobile.wp.ui.place;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.Place;
import ar.com.oxen.nibiru.mobile.core.api.ui.place.PlaceManager;

import com.google.gwt.user.client.History;

public class WindowsPhonePlaceManager implements PlaceManager {
	private static int creationCount;

	@Override
	public Place createPlace(String id) {
		checkNotNull(id);
		return new WindowsPhonePlace(id, creationCount++);
	}

	@Override
	public Place createPlace(Enum<?> id) {
		checkNotNull(id);
		return createPlace(id.toString());
	}

	@Override
	public void back() {
		History.back();
	}
}
