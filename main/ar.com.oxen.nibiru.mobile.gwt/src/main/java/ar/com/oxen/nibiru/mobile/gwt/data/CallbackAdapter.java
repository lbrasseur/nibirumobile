package ar.com.oxen.nibiru.mobile.gwt.data;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;

public class CallbackAdapter implements com.gwtmobile.persistence.client.Callback {
	private Callback<Void> callback;

	public CallbackAdapter(Callback<Void> callback) {
		super();
		this.callback = callback;
	}

	@Override
	public void onSuccess() {
		this.callback.onSuccess(null);

	}
}
