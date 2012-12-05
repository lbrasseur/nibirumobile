package ar.com.oxen.nibiru.mobile.android.http;

import java.util.Scanner;

import javax.inject.Inject;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.config.BaseUrl;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpCallback;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;

public class HttpClientHttpManager implements HttpManager {
	private String baseUrl;

	@Inject
	public HttpClientHttpManager(@BaseUrl String baseUrl) {
		super();
		this.baseUrl = baseUrl;
	}

	@Override
	public <T> void send(String url, Callback<T> callback,
			HttpCallback<T> httpCallback) {
		try {
			HttpClient httpClient = new DefaultHttpClient();

			HttpPost request = new HttpPost(this.baseUrl
					+ "authentication/login");
			request.setEntity(new StringEntity(httpCallback.buildRequest()));

			HttpResponse response = httpClient.execute(request);

			callback.onSuccess(httpCallback.parseResponse(new Scanner(response
					.getEntity().getContent()).useDelimiter("\\A").next()));
		} catch (Exception e) {
			callback.onFailure(e);
		}
	}

}
