package ar.com.oxen.nibiru.mobile.core.api.http;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;

/**
 * Manager for performing requests over HTTP.
 * 
 */
public interface HttpManager {
	/**
	 * Sends a POST reques.
	 * 
	 * @param url
	 *            The URL
	 * @param callback
	 *            A callback for handling the processed response
	 * @param httpCallback
	 *            The callback for message processing
	 */
	<T> void send(String url, final Callback<T> callback,
			final HttpCallback<T> httpCallback);
}
