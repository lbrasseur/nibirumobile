package ar.com.oxen.nibiru.mobile.security.java.service;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import org.codehaus.jackson.map.ObjectMapper;

import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;
import ar.com.oxen.nibiru.mobile.core.impl.service.RestService;
import ar.com.oxen.nibiru.mobile.java.serializer.jackson.JacksonSerializer;

public class JsonRestAuthenticationServiceProvider implements
		Provider<RemoteService> {
	private final HttpManager httpManager;
	private final ObjectMapper mapper;

	@Inject
	public JsonRestAuthenticationServiceProvider(HttpManager httpManager,
			ObjectMapper mapper) {
		this.httpManager = checkNotNull(httpManager);
		this.mapper = checkNotNull(mapper);
	}

	@Override
	public RemoteService get() {
		return new RestService("authentication", httpManager,
				new JacksonSerializer(mapper));
	}
}
