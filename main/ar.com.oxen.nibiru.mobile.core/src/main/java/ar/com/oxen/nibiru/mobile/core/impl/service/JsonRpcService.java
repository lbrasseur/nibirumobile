package ar.com.oxen.nibiru.mobile.core.impl.service;

import ar.com.oxen.nibiru.mobile.core.api.async.Callback;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpCallback;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;
import ar.com.oxen.nibiru.mobile.core.api.serializer.Serializer;

public class JsonRpcService extends BaseService {
	public JsonRpcService(String serviceName, HttpManager httpManager,
			Serializer serializer) {
		super(serviceName, httpManager, serializer);
	}

	@Override
	public <T> void invoke(final String method, final Object requestDto,
			final Class<T> responseClass, Callback<T> callback) {
		this.getHttpManager().send(this.getServiceName(), callback,
				new HttpCallback<T>() {

					@Override
					public String buildRequest() {
						StringBuilder sb = new StringBuilder();
						sb.append("{\"id\":1,\"jsonrpc\":\"jsonrpc\",\"method\":\"");
						sb.append(method);
						sb.append("\"");
						if (requestDto != null) {
							sb.append(",\"params\":[");
							sb.append(getSerializer().serialize(requestDto));
							sb.append("]");
						}
						sb.append("}");
						return sb.toString();
					}

					@Override
					public T parseResponse(String responseMessage) {
						return getSerializer().deserialize(
								extractResult(responseMessage), responseClass);
					}

				});

	}

	private String extractResult(String responseMessage) {
		// TODO: no seria mas simple hacer una abstraccion de un parser de JSON?
		String parameter = "\"result\":";
		int start = responseMessage.indexOf(parameter);

		if (start >= 0) {
			start += parameter.length();
			int end = start;
			int nesting = 0;
			char currentChar = responseMessage.charAt(end);
			while (end <= responseMessage.length()
					&& (nesting > 0 || (currentChar != ',' && currentChar != '}'))) {

				if (currentChar == '{' || currentChar == '[') {
					nesting++;
				} else if (currentChar == '}' || currentChar == ']') {
					nesting--;
				}
				end++;
				if (end <= responseMessage.length()) {
					currentChar = responseMessage.charAt(end);
				} else {
					currentChar = ' ';
				}
			}
			return responseMessage.substring(start, end);

		} else {
			return "";
		}
	}
}
