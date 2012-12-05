package ar.com.oxen.nibiru.mobile.core.impl.async;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;

/**
 * Abstract base class for implementing callbacks.
 *
 * @param <T>
 *            The type returned on success
 */
public abstract class BaseCallback<T> implements Callback<T> {
	private AlertManager alertManager;

	public BaseCallback(AlertManager alertManager) {
		super();
		this.alertManager = alertManager;
	}

	@Override
	public void onFailure(Exception error) {
		this.alertManager.showMessage("Error: " + error.getLocalizedMessage());
	}
}
