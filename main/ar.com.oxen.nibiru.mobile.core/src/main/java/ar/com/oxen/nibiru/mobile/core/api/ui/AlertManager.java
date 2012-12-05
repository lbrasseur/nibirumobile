package ar.com.oxen.nibiru.mobile.core.api.ui;

/**
 * A manager for showing messages to user.
 */
public interface AlertManager {
	/**
	 * Shows an informative message.
	 * 
	 * @param message
	 *            The message
	 */
	void showMessage(String message);

	/**
	 * Shows an error message.
	 * 
	 * @param exception
	 *            The exception which generated the error
	 */
	void showException(Exception exception);
}
