package ar.com.oxen.nibiru.mobile.core.api.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;

/**
 * Something that can notify change events.
 */
public interface HasChangeHandler {
	/**
	 * Sets the change handler.
	 * 
	 * @param changeHandler
	 *            The change handler
	 * @return A handler registration
	 */
	HandlerRegistration setChangeHandler(ChangeHandler changeHandler);
}
