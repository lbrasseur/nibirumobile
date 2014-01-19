package ar.com.oxen.nibiru.mobile.core.impl.mvp;

import static com.google.common.base.Preconditions.checkNotNull;
import ar.com.oxen.nibiru.mobile.core.api.ui.AlertManager;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.Presenter;
import ar.com.oxen.nibiru.mobile.core.api.ui.mvp.View;
import ar.com.oxen.nibiru.mobile.core.impl.async.BaseCallback;

/**
 * Base class for presenters
 * 
 * @param <V>
 *            The view type
 */
abstract public class BasePresenter<V extends View> implements Presenter<V> {
	private final V view;
	private final AlertManager alertManager;

	public BasePresenter(V view, AlertManager alertManager) {
		this.view = checkNotNull(view);
		this.alertManager = checkNotNull(alertManager);
	}

	@Override
	public V getView() {
		return view;
	}

	@Override
	public void onStop() {
	}

	protected AlertManager getAlertManager() {
		return alertManager;
	}

	/**
	 * Utility class for creating internal callbacks.
	 * 
	 * @param <T>
	 *            The callback return type
	 */
	protected abstract class Cbk<T> extends BaseCallback<T> {
		public Cbk() {
			super(alertManager);
		}
	}
}
