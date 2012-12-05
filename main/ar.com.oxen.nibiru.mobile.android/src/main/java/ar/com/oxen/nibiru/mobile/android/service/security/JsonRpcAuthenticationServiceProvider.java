package ar.com.oxen.nibiru.mobile.android.service.security;

import javax.inject.Inject;
import javax.inject.Provider;

import org.codehaus.jackson.map.ObjectMapper;

import ar.com.oxen.nibiru.mobile.android.serializer.JacksonSerializaer;
import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;
import ar.com.oxen.nibiru.mobile.core.impl.service.JsonRpcService;

public class JsonRpcAuthenticationServiceProvider implements
		Provider<RemoteService> {
	private HttpManager httpManager;
	private ObjectMapper mapper;

	@Inject
	public JsonRpcAuthenticationServiceProvider(HttpManager httpManager,
			ObjectMapper mapper) {
		super();
		this.httpManager = httpManager;
		this.mapper = mapper;
	}

	@Override
	public RemoteService get() {
		return new JsonRpcService("authentication", this.httpManager,
				new JacksonSerializaer(this.mapper));
	}
}
