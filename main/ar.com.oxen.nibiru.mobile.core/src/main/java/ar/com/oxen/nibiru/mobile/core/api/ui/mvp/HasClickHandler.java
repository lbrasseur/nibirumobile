package ar.com.oxen.nibiru.mobile.core.api.ui.mvp;

import ar.com.oxen.nibiru.mobile.core.api.handler.HandlerRegistration;

/**
 * Something that can be clicked.
 */
public interface HasClickHandler {
	/**
	 * Sets the click handler.
	 * 
	 * @param clickHandler
	 *            The click handler
	 * @return A handler registration
	 */
	HandlerRegistration setClickHandler(ClickHandler clickHandler);
}
