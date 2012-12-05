package ar.com.oxen.nibiru.mobile.gwt.data;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;

import com.gwtmobile.persistence.client.ScalarCallback;

public class ScalarCallbackAdapter<T, K extends T> implements ScalarCallback<K> {
	private Callback<T> callback;

	public ScalarCallbackAdapter(Callback<T> callback) {
		super();
		this.callback = callback;
	}

	@Override
	public void onSuccess(K result) {
		this.callback.onSuccess(result);

	}
}
