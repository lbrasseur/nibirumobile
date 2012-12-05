package ar.com.oxen.nibiru.mobile.core.api.ui.place;

import ar.com.oxen.nibiru.mobile.core.api.common.Configurable;
import ar.com.oxen.nibiru.mobile.core.api.common.Identifiable;

/**
 * A place.
 */
public interface Place extends Identifiable<String>, Configurable<Place> {
	/**
	 * Navigates to a place (no push).
	 */
	void go();

	/**
	 * Navigates to a place.
	 * 
	 * @param push
	 *            True if previous place must be kept into the stack (allows
	 *            returning later to the current place using
	 *            {@link PlaceManager#back()}).
	 */
	void go(boolean push);
}
