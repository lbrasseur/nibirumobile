package ar.com.oxen.nibiru.mobile.core.impl.async;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;

/**
 * Class for composing two callbacks.
 * 
 * @param <T>
 *            The type returned by the callback
 * @param <C>
 *            The type returned by the chained callback
 */
public abstract class ChainCallback<T, C> implements Callback<T> {
	private Callback<C> chained;

	public ChainCallback(Callback<C> chained) {
		super();
		this.chained = chained;
	}

	protected Callback<C> getChained() {
		return chained;
	}

	@Override
	public void onFailure(Exception error) {
		this.chained.onFailure(error);
	}
}
