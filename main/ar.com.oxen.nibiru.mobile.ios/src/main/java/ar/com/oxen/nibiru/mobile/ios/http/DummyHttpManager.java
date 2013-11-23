package ar.com.oxen.nibiru.mobile.ios.http;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpCallback;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;

public class DummyHttpManager implements HttpManager {

	@Override
	public <T> void send(String url, Callback<T> callback,
			HttpCallback<T> httpCallback) {
		// TODO Auto-generated method stub

	}

}
