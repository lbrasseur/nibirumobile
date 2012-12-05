package ar.com.oxen.nibiru.mobile.gwt.service.security;

import javax.inject.Inject;
import javax.inject.Provider;

import ar.com.oxen.nibiru.mobile.core.api.http.HttpManager;
import ar.com.oxen.nibiru.mobile.core.api.service.RemoteService;
import ar.com.oxen.nibiru.mobile.core.impl.service.RestService;
import ar.com.oxen.nibiru.mobile.gwt.serializer.AutoBeanSerializer;

public class RestAutoBeanAuthenticationServiceProvider implements
		Provider<RemoteService> {
	private HttpManager httpManager;
	private AutoBeanDtoFactory dtoFactory;

	@Inject
	public RestAutoBeanAuthenticationServiceProvider(HttpManager httpManager,
			AutoBeanDtoFactory dtoFactory) {
		super();
		this.httpManager = httpManager;
		this.dtoFactory = dtoFactory;
	}

	@Override
	public RemoteService get() {
		return new RestService("authentication", this.httpManager,
				new AutoBeanSerializer(this.dtoFactory));
	}
}
