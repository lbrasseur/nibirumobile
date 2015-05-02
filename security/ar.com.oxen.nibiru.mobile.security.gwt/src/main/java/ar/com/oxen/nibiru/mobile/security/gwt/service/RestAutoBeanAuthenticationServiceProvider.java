package ar.com.oxen.nibiru.mobile.security.gwt.service;

import static com.google.common.base.Preconditions.checkNotNull;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;
import ar.com.oxen.nibiru.mobile.core.impl.service.RestService;
import ar.com.oxen.nibiru.mobile.gwt.serializer.AutoBeanSerializer;

public class RestAutoBeanAuthenticationServiceProvider implements
		Provider<RemoteService> {
	private final HttpManager httpManager;
	private final AutoBeanDtoFactory dtoFactory;

	@Inject
	public RestAutoBeanAuthenticationServiceProvider(HttpManager httpManager,
			AutoBeanDtoFactory dtoFactory) {
		this.httpManager = checkNotNull(httpManager);
		this.dtoFactory = checkNotNull(dtoFactory);
	}

	@Override
	public RemoteService get() {
		return new RestService("authentication", httpManager,
				new AutoBeanSerializer(dtoFactory));
	}
}
