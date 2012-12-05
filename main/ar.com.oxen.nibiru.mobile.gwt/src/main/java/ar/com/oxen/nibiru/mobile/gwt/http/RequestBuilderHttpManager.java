package ar.com.oxen.nibiru.mobile.gwt.http;

import javax.inject.Inject;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.config.BaseUrl;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpCallback;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;

public class RequestBuilderHttpManager implements HttpManager {
	private String baseUrl;

	@Inject
	public RequestBuilderHttpManager(@BaseUrl String baseUrl) {
		super();
		this.baseUrl = baseUrl;
	}

	@Override
	public <T> void send(String url, final Callback<T> callback,
			final HttpCallback<T> httpCallback) {

		try {
			RequestBuilder requestBuilder = new RequestBuilder(
					RequestBuilder.POST, this.baseUrl + url);

			requestBuilder.sendRequest(httpCallback.buildRequest(),
					new RequestCallback() {

						@Override
						public void onResponseReceived(Request request,
								Response response) {
							try {
								String text = response.getText();

								if (text != null && text.length() == 0) {
									text = null;
								}

								callback.onSuccess(httpCallback
										.parseResponse(text));
							} catch (Exception e) {
								callback.onFailure(e);
							}
						}

						@Override
						public void onError(Request request, Throwable exception) {
							callback.onFailure((Exception) exception);
						}
					});
		} catch (RequestException e) {
			callback.onFailure(e);
		}
	}
}
