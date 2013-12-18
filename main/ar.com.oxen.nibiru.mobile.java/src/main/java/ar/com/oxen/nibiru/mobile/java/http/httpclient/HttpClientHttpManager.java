package ar.com.oxen.nibiru.mobile.java.http.httpclient;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
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

import com.google.common.base.Throwables;
import com.google.common.io.Closer;

public class HttpClientHttpManager implements HttpManager {
	private final String baseUrl;

	@Inject
	public HttpClientHttpManager(@BaseUrl String baseUrl) {
		this.baseUrl = checkNotNull(baseUrl);
	}

	@Override
	public <T> void send(String url, Callback<T> callback,
			HttpCallback<T> httpCallback) {
		try {
			Closer closer = Closer.create();
			try {
				HttpClient httpClient = new DefaultHttpClient();

				HttpPost request = new HttpPost(baseUrl + url);
				request.setEntity(new StringEntity(httpCallback.buildRequest()));

				HttpResponse response = httpClient.execute(request);

				callback.onSuccess(httpCallback.parseResponse(new Scanner(
						closer.register(response.getEntity().getContent()))
						.useDelimiter("\\A").next()));
			} catch (Exception e) {
				callback.onFailure(e);
			} catch (Throwable e) {
				closer.rethrow(e);
			} finally {
				closer.close();
			}
		} catch (IOException ioException) {
			Throwables.propagate(ioException);
		}
	}

}
